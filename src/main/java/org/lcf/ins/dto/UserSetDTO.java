package org.lcf.ins.dto;

import java.util.ArrayList;
import java.util.List;


public class UserSetDTO {

	public List<User> users = new ArrayList<>();
	
	public UserSetDTO(){}
	
	public User put(String userName){
		return new User(userName);
	}
	public User getUser(int position) {
        return users.get(position);
    }
 
    public User getUser(String username) {
        for (User user : users) {
            if (user.username.equals(username)) {
                return user;
            }
        }
        return null;
    }
	
    public final class User {
        public String username;
        public List<Set> list = new ArrayList<>();
 
        private User(String username) {
            this.username = username;
        }
 
        public User set(String productName) {
            this.list.add(new Set(productName));
            return this;
        }
 
        public void create() {
            users.add(this);
        }
 
        public Set find(String productCode) {
            for (Set set : list) {
                if (set.productCode.equals(productCode)) {
                    return set;
                }
            }
            return null;
        }
 
        @Override
        public String toString() {
            return "User{" +
                    "username='" + username + '\'' +
                    '}';
        }
    }
    
    public final class Set implements Comparable<Set> {
        public String productCode;
 
        public Set(String productCode) {
            this.productCode = productCode;
        }
 
        @Override
        public String toString() {
            return "Set{" +
                    "productCode='" + productCode+
                    '}';
        }

		@Override
		public int compareTo(Set o) {
			// TODO Auto-generated method stub
			return 0;
		}
    }

}
