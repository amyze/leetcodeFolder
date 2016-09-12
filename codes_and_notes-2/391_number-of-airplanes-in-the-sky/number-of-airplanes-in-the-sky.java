/*
@Copyright:LintCode
@Author:   amyzen
@Problem:  http://www.lintcode.com/problem/number-of-airplanes-in-the-sky
@Language: Java
@Datetime: 16-09-01 17:02
*/

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
class Point{
    int time;
    boolean isStart;

    Point(int t, boolean s){
      this.time = t;
      this.isStart = s;
    }
    public static Comparator<Point> PointComparator  = new Comparator<Point>(){
      public int compare(Point p1, Point p2){
        if(p1.time != p2.time) return Integer.compare(p1.time, p2.time);
        return p1.isStart&&!p2.isStart?1:!p1.isStart&&p2.isStart?-1:0;
      }
    };
}
class Solution {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) { 
        List<Point> list = new ArrayList<>(airplanes.size()*2);
    for(Interval i : airplanes){
      list.add(new Point(i.start, true));
      list.add(new Point(i.end, false));
    }

    Collections.sort(list,Point.PointComparator );
    int count = 0, ans = 0;
    for(Point p : list){
      if(p.isStart) count++;
      else count--;
      ans = Math.max(ans, count);
    }

    return ans;
    }
}