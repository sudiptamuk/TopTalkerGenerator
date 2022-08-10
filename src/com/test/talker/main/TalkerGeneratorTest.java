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

import java.util.ArrayList;
import java.util.List;

import com.test.talker.pojo.ChatMessage;
import com.test.talker.pojo.TopTalker;

/**
 * @author sudip
 *
 */
public class TalkerGeneratorTest {


	/**
	 * We need to run the main method to run the tests
	 */
	public static void main(String[] args) {
		System.out.println("Started Main Method");
		List<ChatMessage> inputChatMessages = new ArrayList<>();

		//Input Chat messages with below message counts
		// Data Scenarios created to handle multiple candidates with same count values
		// A = 5; B = 2; C = 2; D = 5; E = 1
		ChatMessage cm1 = new ChatMessage("A", "I am A");
		ChatMessage cm2 = new ChatMessage("B", "I am B");
		ChatMessage cm3 = new ChatMessage("A", "I am A");
		ChatMessage cm4 = new ChatMessage("D", "I am A");
		ChatMessage cm5 = new ChatMessage("C", "I am C");
		ChatMessage cm6 = new ChatMessage("A", "I am A");
		ChatMessage cm7 = new ChatMessage("B", "I am B");
		ChatMessage cm8 = new ChatMessage("D", "I am D");
		ChatMessage cm9 = new ChatMessage("E", "I am E");
		ChatMessage cm10 = new ChatMessage("C", "I am C");
		ChatMessage cm11 = new ChatMessage("D", "I am D");
		ChatMessage cm12 = new ChatMessage("D", "I am D");
		ChatMessage cm13 = new ChatMessage("A", "I am A");
		ChatMessage cm14 = new ChatMessage("D", "I am D");
		ChatMessage cm15 = new ChatMessage("A", "I am A");

		//Populating the List of Chat messages
		inputChatMessages.add(cm1);
		inputChatMessages.add(cm2);
		inputChatMessages.add(cm3);
		inputChatMessages.add(cm4);
		inputChatMessages.add(cm5);
		inputChatMessages.add(cm6);
		inputChatMessages.add(cm7);
		inputChatMessages.add(cm8);
		inputChatMessages.add(cm9);
		inputChatMessages.add(cm10);
		inputChatMessages.add(cm11);
		inputChatMessages.add(cm12);
		inputChatMessages.add(cm13);
		inputChatMessages.add(cm14);
		inputChatMessages.add(cm15);
		
		System.out.println("Setting up the Talker generator Object");
		TalkerGenerator gen = new TalkerGenerator(inputChatMessages);

		System.out.println("Start tests..");
		//Running the test methods for different scenarios
		testForTopThree(gen);
		testForTopOne(gen);
		testForTopTen(gen);
		testForTopZero(gen);
		testForTopNegativeValue(gen);

		System.out.println("End Tests..");
	}

	/**
	 * Positive Test for top three
	 * @param gen The populated TalkerGenerator Object
	 */
	private static void testForTopThree(TalkerGenerator gen) {
		int n = 3;
		printContent(gen, n);
	}

	/**
	 * Positive Test for top One
	 * @param gen The populated TalkerGenerator Object
	 */
	private static void testForTopOne(TalkerGenerator gen) {
		int n = 1;
		printContent(gen, n);
	}

	/**
	 * Test for top ten - Negative test when there is less than 10 talkers
	 * @param gen The populated TalkerGenerator Object
	 */
	private static void testForTopTen(TalkerGenerator gen) {
		int n = 10;
		printContent(gen, n);
	}

	/**
	 * Test for top zero - Negative test when zero value is passed
	 * @param gen The populated TalkerGenerator Object
	 */
	private static void testForTopZero(TalkerGenerator gen) {
		int n = 0;
		printContent(gen, n);
	}

	/**
	 * Negative test when negative value is passed
	 * @param gen The populated TalkerGenerator Object
	 */
	private static void testForTopNegativeValue(TalkerGenerator gen) {
		int n = -3;
		printContent(gen, n);
	}

	private static void printContent(TalkerGenerator gen, int n) {
		System.out.println("Getting top " + n + " talkers..");
		List<TopTalker> top = gen.getTopTalker(n);

		System.out.println("Received list:" + top.size());

		top.forEach(a -> System.out.println(a.toString()));
		System.out.println("\n");
	}
}
