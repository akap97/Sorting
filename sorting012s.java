public static void sort012(int a[], int n){
    // code here 
    int count[]=new int[3];
    int res[]=new int[n];
    for(int i=0;i<n;i++)
        count[a[i]]++;
    int pos[]=new int[3];
    pos[0]=0;
    for(int j=1;j<3;j++)
        pos[j]=pos[j-1]+count[j-1];
    for(int i=0;i<n;i++)
        {
            res[pos[a[i]]]=a[i];
            pos[a[i]]++;
        }
    for(int i=0;i<n;i++)
        a[i]=res[i];
}
