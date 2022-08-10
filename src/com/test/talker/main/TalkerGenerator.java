/**
 * Pre-Assessment Question
 * You are part of a team working on a new chat application. Your task is to
 * provide a way to generate the top n talkers from a list of messages. Top talkers are
 * users with the most number of ChatMessages.
 *
 * Requirements:
 *   1. TopTalkerGenerator class must have a way to ingest List<ChatMessage>
 *   2. TopTalkerGenerator class must have a way to output n top talkers e.g. List<TopTalker>
 *   3. Please add comments about space and time complexity of the solution above TopTalkerGenerator class
 *
 * Example:
 * Given chat messages from users
 * [userA, userA, userA, userB, userC, userC]
 * userA messageCount = 3
 * userB messageCount = 1
 * userC messageCount = 2
 * The top two talkers (n = 2) would be [userA, userC]
**/
package com.test.talker.main;

import com.test.talker.pojo.ChatMessage;
import com.test.talker.pojo.TopTalker;

import java.util.*;

/**
 * @author sudip
 *
 */
public class TalkerGenerator {

	
	List<ChatMessage> chatMessages;
	
	/**
	 * 
	 */
	public TalkerGenerator(List<ChatMessage> inputChatMessages) {
		
		chatMessages = inputChatMessages;
	}

	/**
	 * get the top talkers
	 * Time Complexity is the most time-consuming of the granular operations inside the method
	 * Time Complexity here is O(NlogN) for the sorting process
	 * Best Case Time Complexity possibility here is O(N)
	 * Space complexity is the amount of memory used for operations which is proportional
	 * to the values stored in the list which will grow linear
	 * Space Complexity = O(N)
	 */
	public List<TopTalker> getTopTalker(int n) {

		List<TopTalker> topTalkers = new ArrayList<>();
		
		Map<String, TopTalker> talkCounts = new HashMap<>();

		//Looping through the chat messages list is proportional to the length of the list
		//Time Complexity O(N)
		//Space Complexity is O(N)
		for(ChatMessage cm : chatMessages) {
			String talkUser = cm.getUser();
			// Hashmap get/search a constant time operation O(1)
			// The Worst Case O(N) = Very rarely happens we can safely ignore
			TopTalker talker = talkCounts.get(talkUser);
			//If talker is found yet in the HashMap
			if(talker != null) {
				talker.addOneCountForUser();
				// Hashmap put a constant time operation O(1)
				// Space complexity is O(1)
				talkCounts.put(talkUser, talker);
			}else {
				//If talker is not found in the HashMap create a fresh new and insert into the Map
				TopTalker newTalker = new TopTalker(talkUser);
				newTalker.addOneCountForUser();
				// Hashmap put a constant time operation O(1)
				// Space complexity is O(1)
				talkCounts.put(talkUser, newTalker);				
			}
		}
		//Create a list of Value objects from the Map Values with final message counts
		List<TopTalker> talkerList = new ArrayList<>(talkCounts.values());

		//Sort the list of Talkers so that we can find the top talkers by just
		//picking up the subset of the list till that value
		//Efficient sorting algorithm will be of time complexity O(NlogN)
		talkerList.sort(new SortbyMessageCount());

		//Ignore any value of n as zero or less than zero as zero means pick up the top zero
		//Negative value of n is irrational in that case return empty list
		//Time Complexity Insert/Remove from a list from its beginning is O(1) operation
		if(n>0) {
			topTalkers = talkerList.subList(0, Math.min(n, talkerList.size()));
		}
		
		return topTalkers;
	}

}

/**
 * Final class of a Comparator to sort by message count in descending order
 */
final class SortbyMessageCount implements Comparator<TopTalker> {

	/**
	 * Used for sorting in descending order of message count
	 * @param a the first object to be compared.
	 * @param b the second object to be compared.
	 */
    public int compare(TopTalker a, TopTalker b)
    {
        return b.getMessageCount() - a.getMessageCount();
    }
}