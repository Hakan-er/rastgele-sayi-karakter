/**  
* @author Hakan Eryücel b171210045@ogr.sakarya.edu.tr
* @since 19/3/2019  
* <p>  
* RastgeleKarakter sınıfı test programı.
* </p>  
*/
package testrastgelekarakter;
import RastgeleKarakter.RastgeleKarakter;
public class TestRastgeleKarakter 
{
    public static void main(String[] args)
    {
        RastgeleKarakter rnd=new RastgeleKarakter();
        System.out.println("Rastgele Tek karakter : "+rnd.karakterUret());
        System.out.println("Rastgele Tek karakter : "+rnd.karakterUret());
        System.out.println("Rastgele Tek karakter : "+rnd.karakterUret());
        System.out.println("-----------------------------------");
        System.out.println("Rastgele 100 karakter : "+rnd.karakterUret(100));
        System.out.println("Rastgele 80 karakter  : "+rnd.karakterUret(80));
        System.out.println("Rastgele 90 karakter  : "+rnd.karakterUret(90));
        System.out.println("-----------------------------------");
        System.out.println("d-h arası rastgele tek karakter : "+rnd.araKarakter('d','h'));
        System.out.println("a-e arası rastgele tek karakter : "+rnd.araKarakter('a','e'));
        System.out.println("g-p arası rastgele tek karakter : "+rnd.araKarakter('g','p'));
        System.out.println("-----------------------------------");
        System.out.println("t-z arası rastgele 100 karakter: "+rnd.araKarakter('t','z',100));
        System.out.println("f-l arası rastgele 80 karakter : "+rnd.araKarakter('f','l',80));
        System.out.println("A-Z arası rastgele 90 karakter : "+rnd.araKarakter('A','Z',90));
        System.out.println("-----------------------------------");
        System.out.println("a-k-g-h-n arasından rastgele bir karakter : "+rnd.belirtilenKarakter('a','k','g','h','n'));
        System.out.println("a-k-g-h-n arasından rastgele bir karakter : "+rnd.belirtilenKarakter('a','k','g','h','n'));        
        System.out.println("a-k-g-h-n arasından rastgele bir karakter : "+rnd.belirtilenKarakter('a','k','g','h','n'));
        System.out.println("-----------------------------------");
        System.out.println("q-W-z-b-T arasından rastgele 100 karakter: "+rnd.belirtilenKarakter(100,'q','W','z','b','T'));
        System.out.println("a-v-l-r-o arasından rastgele 80 karakter : "+rnd.belirtilenKarakter(80,'a','v','l','r','o'));
        System.out.println("-----------------------------------");
        System.out.println("Rastgele cümle: "+rnd.cumleOlustur());
        System.out.println("Rastgele cümle: "+rnd.cumleOlustur());
        System.out.println("Rastgele cümle: "+rnd.cumleOlustur());
    }
}
