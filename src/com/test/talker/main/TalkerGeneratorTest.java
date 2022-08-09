/**
 * 
 */
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
	 */
	public static void main(String[] args) {
		System.out.println("Started Main Method");
		List<ChatMessage> inputChatMessages = new ArrayList<>();
		
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
		
		System.out.println("Calling Talker generator");
		TalkerGenerator gen = new TalkerGenerator(inputChatMessages);
		int n = 1;
		System.out.println("Getting top " + n + " talkers..");
		List<TopTalker> top = gen.getTopTalker(n);
		
		System.out.println("Received list:" + top.size());
		
		top.forEach(a -> System.out.print(a.toString()));
		

	}

}
