import java.util.Scanner;
public class Koccurence{
   public static int[] arr,krr;
   public static int n;
    Koccurence(){
        n=0;
    }
 /**
 * 
 */
public static void readArray()
 { Scanner read=new Scanner(System.in);
    System.out.println("Enter the size of the array to be inserted");
    n=read.nextInt();
    arr=new int[n];
    System.out.println("Enter values into this array");
    for (int i = 0; i < n; i++) {
        arr[i] = read.nextInt();
    }

}
int checkk(int k){
        int count;
        System.out.println("Enter the value for k");
        k=read.nextInt();
        if (k>n)
    { System.out.println("K value shouldn't be bigger than the array size");
    System.exit(0);
}
        for (int i = 0; i < n; i++) {
            count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] == arr[i])
                    ++count;
            }
            krr[i]=count;
            }
        }
    public static void sort()
    { for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
            if (krr[i] < krr[arr[j]]) {
                int temp = arr[i];
                int tem = krr[i];
                arr[i] = arr[j];
                krr[i]=krr[j];
                arr[j] = temp;
                krr[j]
            }
        }
    }}

    
    }



