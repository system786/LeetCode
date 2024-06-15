class Solution {
    public double[] calcEquation(List<List<String>> eq, double[] vals, List<List<String>> que) {

       HashMap<String,ArrayList<Pair>> map = new HashMap<>();

       for(int i = 0;i<eq.size();i++){
           String fr = eq.get(i).get(0);
           String to = eq.get(i).get(1);
           double val = vals[i];
           if(!map.containsKey(fr)) map.put(fr,new ArrayList<>());
           if(!map.containsKey(to)) map.put(to,new ArrayList<>());
           Pair fp = new Pair(to,val);
           Pair tp = new Pair(fr,1.0/val);
           map.get(fr).add(fp);
           map.get(to).add(tp);
       }

       
       double[] ret  =new double[que.size()];
       for(int i = 0;i<ret.length;i++){
           String cf = que.get(i).get(0);
           String ct = que.get(i).get(1);
           if(!map.containsKey(cf) || !map.containsKey(ct)){
                ret[i]=-1;continue;
            }
           ret[i] = bfs(map,cf,ct);
       }

        return ret;
    }

    double bfs(HashMap<String,ArrayList<Pair>> map,String from,String to){
        HashSet<String> vis= new HashSet<>();

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(from,1.0));

        while(!q.isEmpty()){
            Pair cur = q.poll();
//  If the cur node is the target i.e if a/e is asked then e ,so we got the answer hence return
            if(cur.node.equals(to)) return cur.val;
// To make sure the node isn't visited again(set is better cz O(1) to check 
            vis.add(cur.node);
// Do traverse all neighbors i.e if a/b exists go to b and hence 
            for(Pair ad:map.get(cur.node)){
                if(!vis.contains(ad.node)){
                    q.offer(new Pair(ad.node,cur.val*ad.val));
                }
            }
        }
        return -1.0;
    }
}
// Custom pair class to store node,val 
class Pair{
    String node;
    double val;
    Pair(String node,double val){
        this.node = node;
        this.val=val;
    }
}
