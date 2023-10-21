package problems.Q0001_Q0030;

public class Q0010RegularExpressionMatching {

  char currentPattern = ' ';
  int lengthString;
  int lengthPattern;
  String s;
  String p;

  public boolean isMatch(String s, String p) {
    this.s = s;
    this.p = p;
    this.lengthString = s.length();
    this.lengthPattern = p.length();
    return isMatch(0, 0);
  }

  public boolean isMatch(int indexString, int indexPattern) {
    // end cases
    if (indexString == lengthString) {
      if (indexPattern >= lengthPattern) return true;
      if (p.charAt(indexPattern) == '*') indexPattern += 1;
      while (indexPattern < lengthPattern) {
        if (indexPattern + 1 < lengthPattern && p.charAt(indexPattern + 1) == '*')
          indexPattern += 2;
        else return false;
      }
      return true;
    }

    if (indexPattern >= lengthPattern) return false;

    while (indexString < lengthString && indexPattern < lengthPattern) {
      // guarantee to be either '.' or letters
      currentPattern = p.charAt(indexPattern);
      if (indexPattern + 1 < lengthPattern && p.charAt(indexPattern + 1) == '*') {
        if (matchAt(indexString)) {
          if (indexPattern + 2 == lengthPattern) {
            while (indexString < lengthString && matchAt(indexString)) {
              indexString++;
            }
            return indexString >= lengthString;
          }
          boolean success = false;
          int offset = 0;
          char tmp = currentPattern;
          while (!success
              && offset + indexString < lengthString
              && matchAt(offset + indexString, tmp)) {
            success = isMatch(offset + indexString, indexPattern + 2);
            offset += 1;
          }
          success = success || isMatch(offset + indexString, indexPattern + 2);
          return success;
        } else {
          return isMatch(indexString, indexPattern + 2);
        }
      }
      if (matchAt(indexString)) {
        indexPattern += 1;
        indexString += 1;
      } else return false;
    }
    return isMatch(indexString, indexPattern);
  }

  private boolean matchAt(int i) {
    if (currentPattern == '.') return true;
    return currentPattern == s.charAt(i);
  }

  private boolean matchAt(int i, char pattern) {
    if (pattern == '.') return true;
    return pattern == s.charAt(i);
  }
}
