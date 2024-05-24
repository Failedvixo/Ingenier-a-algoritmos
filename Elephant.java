import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Elephant{

    public static void main (String[] args) throws IOException{
       
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        
        List<Pair> elephant = new ArrayList<>();
      
        String s;
        int pos = 1;
        while(true){
            //System.out.println(j);
            s = br.readLine();
            if (s==null || s.equals("")) {
                break;
            }

            StringTokenizer st=new StringTokenizer(s);
            Pair p= new Pair();
            p.w = Integer.parseInt(st.nextToken());
            p.iq = Integer.parseInt(st.nextToken());
            p.pos = pos;
            pos++;
            elephant.add(p);

        }

 

        Hashtable<Pair, Integer> hashtable = new Hashtable<>();
        for(int i=0; i<elephant.size(); i++){
            hashtable.put(elephant.get(0), i+1);
        }

        Comparator<Pair> pairComparator = new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
               
                if(p1.w != p2.w){
                    return Integer.compare(p1.w, p2.w);
                } 
                else{
                   
                    return Integer.compare(p2.iq, p1.iq);
                }
            }
        };
        Collections.sort(elephant, pairComparator);


        List<Pair> sol= new ArrayList<Pair>();

        sol.add(elephant.get(0));

        for(int i=1; i<9; i++){
            if(elephant.get(i).w > sol.get(sol.size()-1).w  && elephant.get(i).iq > sol.get(sol.size()-1).iq){
                sol.set(sol.size()-1, elephant.get(i));
            }

            else if(elephant.get(i).w > sol.get(sol.size()-1).w && elephant.get(i).iq < sol.get(sol.size()-1).iq){
                sol.add(elephant.get(i));
            }
        }

        System.out.println(sol.size());

        for(int i=0; i<sol.size(); i++){
            System.out.println(sol.get(i).pos);
        }
        


    }

}

class Pair{
    int w;
    int iq;
    int pos;

}