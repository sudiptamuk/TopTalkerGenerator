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
	 * Time Complexity
	 *
	 *
	 *
	 */
	public List<TopTalker> getTopTalker(int n) {

		List<TopTalker> topTalkers = new ArrayList<>();
		
		Map<String, TopTalker> talkCounts = new HashMap<>();
		
		for(ChatMessage cm : chatMessages) {
			String talkUser = cm.getUser();
			TopTalker talker = talkCounts.get(talkUser);
			if(talker != null) {
				talker.addOneCountForUser();
				talkCounts.put(talkUser, talker);
			}else {
				TopTalker newTalker = new TopTalker(talkUser);
				newTalker.addOneCountForUser();
				talkCounts.put(talkUser, newTalker);				
			}
		}
		
		List<TopTalker> talkerList = new ArrayList<>(talkCounts.values());
		
		talkerList.sort(new SortbyMessageCount());
		
		if(n>0) {
			topTalkers = talkerList.subList(0, Math.min(n, talkerList.size()));
		}
		
		return topTalkers;
	}

}

final class SortbyMessageCount implements Comparator<TopTalker> {
	  
    // Used for sorting in descending order of
    // roll number
    public int compare(TopTalker a, TopTalker b)
    {
        return b.getMessageCount() - a.getMessageCount();
    }
}