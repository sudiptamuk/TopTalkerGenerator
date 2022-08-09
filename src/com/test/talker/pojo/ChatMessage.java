/**
 * 
 */
package com.test.talker.pojo;

import java.time.Instant;

/**
 * @author sudip
 *
 */
public class ChatMessage {
    private final String user;

    private final String message;

    private final Long timestamp;
    
    public ChatMessage(String inputUser, String inputMessage) {
    	this.user = inputUser;
    	this.message = inputMessage;
    	
    	Instant instant = Instant.now();
    	
    	this.timestamp = instant.toEpochMilli();
    }

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	@Override
	public String toString() {
		return "ChatMessage [user=" + user + ", message=" + message + ", timestamp=" + timestamp + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChatMessage other = (ChatMessage) obj;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		if (user == null) {
			return other.user == null;
		} else return user.equals(other.user);
	}

	
}
