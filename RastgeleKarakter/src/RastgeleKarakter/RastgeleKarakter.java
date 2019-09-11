/**  
* @author Hakan Eryücel b171210045@ogr.sakarya.edu.tr
* @since 19/3/2019  
* <p>  
* Rastgele değer ve rastgele karakter oluştururan sınıf kütüphanesi.
* </p>  
*/
package RastgeleKarakter;
public class RastgeleKarakter 
{
    private double seed;//Seed degiskeninde her zaman 0 ile 1 arasında bir sayı tutulacak.Bu sayı rastgele değer üretilirken kullanılacak.
    
    public RastgeleKarakter()
    {
        this.seed=Double.parseDouble("0."+System.nanoTime());//Seed değişkenine nanotime'dan dönen değerin başına 0. koyarak aktarıyoruz.
    }
    
    private void seed()//Her rastgele değer istendiğinde bu fonksiyon ile seed yeniliyoruz.
    {
        //Rastgele değerimiz; (seed+((nanoTime%10+1)*Pi sayısı)) üzeri 8 işleminin sonuncunun virgülden sonraki kısmı oluyor.
        //Bu değeri rastgele değer olarak kullanıyoruz ve bir sonraki işlemde kullanmak için seed değişkenine atıyoruz.
        double tmp =Math.pow((seed+((System.nanoTime()%10+1)*Math.PI)),8)-Math.floor(Math.pow((seed+((System.nanoTime()%10+1)*Math.PI)),8));
        while(tmp<=0)
        {
            tmp =Math.pow((seed+((System.nanoTime()%10+1)*Math.PI)),8)-Math.floor(Math.pow((seed+((System.nanoTime()%10+1)*Math.PI)),8));
        }
        this.seed=tmp;
    }
    
    private int getirInt()//Integer rastgele değer döndürür.
    {
        seed();//Seed değişkenimiz yenileniyor.
        int nokta=(seed+"").indexOf(".");
        //Seed değişkenimiz rasyonel bir sayı olduğu için tamsayı haline çevirip integer olarak geri döndürüyor.
        return (int)((Double.parseDouble((seed+"").substring(nokta+1)))%Integer.MAX_VALUE);
    }
    
    private char karakterUret(int baslangic,int bitis)//Verilen iki karakter arasında rastgele karakter oluşturan fonksiyon.
    {
        int aralik=Math.abs(bitis-baslangic)+1;
        char karakter=(char)(getirInt()%aralik+baslangic);
        while(karakter<97&&karakter>90)
        {
            karakter=(char)(getirInt()%aralik+baslangic);
        }
        return karakter;
    }
    
    public char karakterUret()//Rastgele karakter üreten fonksiyon.
    {
        //karakterUret metodunu tüm karakterler için geçerli olacak şekilde çaığırıp gelen karakteri döndürüyor.
        return karakterUret('A','z');
    }
    
    public String karakterUret(int karakterSayisi)//Verilen sayida karakter üreten fonksiyon.
    {
        String karakterler="";
        for(int i=0;i<karakterSayisi;i++)
        {
            //karakterUret metodunu istenilen sayıda çağırıyor ve gelen karakterleri bir Stringde tutuyor.
            karakterler+=karakterUret('A','z');
        }
        //Tüm karakterleri bir string olarak döndürüyor.
        return karakterler;
    }
    
    public char araKarakter(char baslangicKarakteri, char bitisKarakteri)//Verilen iki aralıkta karakter üreten fonksiyon.
    {
        //Verilen karakterlerin sırasının ascii sırasında olup olmadığını kontrol edip duruma göre karakterUret metodunu çağırıyor.
        return baslangicKarakteri<bitisKarakteri?karakterUret(baslangicKarakteri+1,bitisKarakteri-1):karakterUret(bitisKarakteri+1,baslangicKarakteri-1);  
    }
    
    public String araKarakter(char baslangicKarakteri, char bitisKarakteri,int karakterSayisi)//Verilen aralıkta istenilen sayıda karakter döndüren fonksiyon.
    {
        String karakterler="";//Karakterlerin tamamı string de tutuluyor.
        for(int i=0;i<karakterSayisi;i++)
        {
            //Ascii sırasını kontrol edip karakterUret metodu çağrılıyor.
            if(baslangicKarakteri<bitisKarakteri)
            {
                karakterler+=karakterUret(baslangicKarakteri+1,bitisKarakteri-1);
            }
            else
            {
                karakterler+=karakterUret(bitisKarakteri+1,baslangicKarakteri-1);
            }
        }
        //Tüm karakterleri string olarak döndürüyor.
        return karakterler;
    }
    
    public char belirtilenKarakter(char... karakterler)// Verilen parametreler arasından rastgele birini döndüren fonksiyon.
    {
        int karakterSayisi=karakterler.length;
        //Rastgele değerin karakter sayısına göre modunu alıp sonuçta çıkan karakteri döndürüyor.
        return karakterler[getirInt()%karakterSayisi];
    }
    
    public String belirtilenKarakter(int karakterSayisi,char... karakterler)//Verilen parametreler arasından rastgele ve istenilen sayıda döndüren fonksiyon.
    {
        String sonuc="";
        for(int i=0;i<karakterSayisi;i++)
        {
            //İstenilen sayıda belirtilenKarakter metodu çağrılıp sonuçlar string değişkende tutuluyor.
            sonuc+=belirtilenKarakter(karakterler);
        }
        //Tüm karakterleri string olarak döndürüyor.
        return sonuc;
    }
    
    public String cumleOlustur()//Rastgele cümle kuran fonksiyon.
    {
        int kelimeSayisi=getirInt()%10+4;//En az 4 kelime en fazla 13 kelime olabilecek şekilde rastgele kelime sayısı belirleniyor.
        String cumle=""+araKarakter('A','Z');
        for(int i=0;i<kelimeSayisi;i++)
        {
            if(i!=kelimeSayisi-1)
            {
                //3 ile 12 harf arasında kelime rastgele oluşturuyor.
                cumle+=araKarakter('a','z',getirInt()%10+3)+" ";
            }
            else
            {
                //Son kelime ise boşluk yerine nokta atıyor.
                cumle+=araKarakter('a','z',getirInt()%10+3)+".";
            }
        }
        //Cümleyi string olarak döndürüyor.
        return cumle;
    }
}

