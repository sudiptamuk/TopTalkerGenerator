/**
 * 
 */
package com.test.talker.pojo;

/**
 * @author sudip
 *
 */
public class TopTalker {
    
	private final String user;

    private Integer messageCount = 0;
    
    public TopTalker (String inputUser) {
    	this.user = inputUser;
    }

	public Integer getMessageCount() {
    	return this.messageCount;
    }
    
    public void addOneCountForUser() {
    	messageCount = messageCount + 1;
    }

	@Override
	public String toString() {
		return "TopTalker [user=" + user + ", messageCount=" + messageCount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((messageCount == null) ? 0 : messageCount.hashCode());
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
		TopTalker other = (TopTalker) obj;
		if (messageCount == null) {
			if (other.messageCount != null)
				return false;
		} else if (!messageCount.equals(other.messageCount))
			return false;
		if (user == null) {
			return other.user == null;
		} else return user.equals(other.user);
	}
    
    
    
}
