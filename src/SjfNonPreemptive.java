import java.util.Scanner;
class data{
    private Scanner s=new Scanner(System.in);
    public int pId;
    public int pBt;
    public int pAt;
    public int pCt;
    public void getProcesses(){
        System.out.println("Enter the Process Id,Process Arrival Time &Process Burst Time");
        pId=s.nextInt();
        pAt=s.nextInt();
        pBt=s.nextInt();
    }
}
public class SjfNonPreemptive {
    private static int n=5;
    private static void initialiseDataArray(data ex[]){
        for(int i=1;i<=n;i++){
            ex[i]=new data();
        }
    }
    private static void processData(data ex[]){//get the process data
        for(int i=1;i<=n;i++){
            ex[i].getProcesses();//'ex' can be for any object array of the class 'data';this line collects the attributes
        }
    }
    private static void shortBtOfArrivedProcess(data ex[]){//data ex[],int start,int arrivedProcess
        int i,j;
        data variable=new data();// here i don't need a data array cos variable is going to hold a single object for a while
        for (i=1;i<=n;i++){
            for (j=i+1;j<=n;j++){
                if (ex[i].pBt>ex[j].pBt) {
                    variable = ex[i];
                    ex[i]= ex[j];
                    ex[j]= variable;
                }
            }
        }
    }
    private static void completionTime(data ex[]){
        shortBtOfArrivedProcess(ex);
        int cmt=0;
        for (int i=1;i<=n;i++){
            cmt+=ex[i].pBt;
            ex[i].pCt=cmt;
            System.out.println("ct of"+ex[i].pId+" is " +cmt);
        }
//        int count=0;//counting the process which are arrived at the ready queue;
//        int start=1;//where processing of the processes have reached;
//        int j=1;//process array starts from 1;
//        int s=0;//The completion times before putting to the array
//        boolean flag=false;
//        while (ex[j].pAt == 0){
//            flag=true;
//            count++;
//            if(j==n){
//                System.out.println("O'O can't overflow");
//                break;
//            }
//            j++;
//        }
//        while (flag){
//                shortBtOfArrivedProcess(ex, start, count);
//                for (int x = start; x <= count; x++) {
//                    s = s + ex[x].pBt;
//                    ex[x].pCt = s;
//                }
//            start=j; //we just finished processing upto count so our next target is to process the remaining process form (count+1)th position
//            flag=false;
//        }
//
//        for(int i=j;i<=n;i++)
//        {
//            if(count<i){
//            while (ex[j].pAt<=ex[j-1].pCt){
//                flag=true;
//                count++;
//                if(j==n){
//                    System.out.println("O'O can't overflow");
//                    break;
//                }
//                j++;
//            }
//            while (flag) {
//                    shortBtOfArrivedProcess(ex,start, count);
//                    for (int x = start; x <= count; x++) {
//                        s = s + ex[x].pBt;
//                        ex[x].pCt = s;
//                    }
//                start = j;
//                flag=false;
//            }
//            if(j>n){
//                System.out.println("Hmm you are free to go");
//                break;
//            }
//            else {
//                if (ex[j].pAt > ex[j - 1].pCt){
//                    int diff = (ex[j].pAt - ex[j - 1].pCt);
//                    System.out.println("idle CPU for " + diff + " unit of time from " + ex[j - 1].pCt + " till " + ex[j].pAt);
//                    s = s + diff;
//                    while (ex[j].pAt<=s){
//                        flag = true;
//                        count++;
//                        if (j == n){
//                            System.out.println("O'O can't overflow");
//                            break;
//                        }
//                        j++;
//                    }
//                    while (flag){
//                        shortBtOfArrivedProcess(ex, start, count);
//                        for (int x = start; x <= count; x++) {
//                            s = s + ex[x].pBt;
//                            ex[x].pCt = s;
//                        }
//                        flag = false;
//                        start = j;
//                    }
//                }
//            }
//            }
//        }
    }
    public static void main(String [] args){
        data tab[]=new data[100];
        initialiseDataArray(tab);
        processData(tab);
        completionTime(tab);
    }
}
/*All Rights Reserved
Nongjaimayum Annas khan
Husband of Ph Tabasum Sahani
*/