//package problems;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Q0010RegularExpressionMatching {
//    List<Group> groups = new ArrayList<>();
//    public boolean isMatch(String s, String p) {
//        int indexP = p.length() - 1;
//        int indexS = s.length() - 1;
//        while (indexS >= 0 && indexP >= 0) {
//            if (p.charAt(indexP) == '*') {
//                Character c = p.charAt(indexP - 1);
//                if (indexP - 2 > 0 && )
//            }
//        }
//
//        return true;
//    }
//    public void grouping(String pattern) {
//        int index = 0;
//        while (index < pattern.length()) {
//            char c = pattern.charAt(index);
//           if (index + 1 < pattern.length()) {
//               if (pattern.charAt(index + 1) == '*') {
//                   if ()
//               } else if () {
//
//               } else groups.add(new Group(1, c));
//           }
//        }
//    }
//
//    public class Group {
//        int required; // 0: 0 or more, -1: 1 or more
//        Character c;
//        public Group(int required, Character c) {
//            this.required = required;
//            this.c = c;
//        }
//    }
//}
