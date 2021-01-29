package rs.edu.viser.aksovicdalibor;

import rs.edu.viser.aksovicdalibor.article.Article;
import rs.edu.viser.aksovicdalibor.article.ArticleService;
import rs.edu.viser.aksovicdalibor.user.User;
import rs.edu.viser.aksovicdalibor.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupData implements CommandLineRunner {

    private final UserService userService;
    private final ArticleService articleService;

    @Autowired
    public StartupData(UserService userService, ArticleService articleService) {
        this.userService = userService;
        this.articleService = articleService;
    }

    @Override
    public void run(String... args) {
    	usersInfo();
        articlesInfo();
    }

    private void usersInfo(){
    	
        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setPasswordConfirm("admin");
        admin.setGender("Musko");
        admin.setEmail("admin@eg.com");
        admin.setAge(22);
        admin.setFirstName("Dalibor");
        admin.setLastName("Aksovic");
        admin.setCity("Beograd");
        userService.save(admin);
        
        
        User user = new User();
        user.setUsername("user");
        user.setPassword("user");
        user.setPasswordConfirm("user");
        user.setGender("Musko");
        user.setEmail("defKorisnik@eg.com");
        user.setAge(22);
        user.setFirstName("Default");
        user.setLastName("Korsinik 1");
        user.setCity("Beograd");
        userService.save(user);
    }
    

    private void articlesInfo(){
    	
        final String NAME = "UNDER ARMOUR Undeniable Duffel 4.0";
        final String IMAGE_URL = "https://www.sportvision.rs/files/thumbs/files/images/slike_proizvoda/thumbs_600/1342657-040_600_600px.jpg";
        final String DESCRIPTION = "Kvalitetni saputnik na putu ka boljem i zdravijem životu!";
        final Double PRICE = 5590.0;
        Article article1 = new Article();
        article1.setName(NAME);
        article1.setImageUrl(IMAGE_URL);
        article1.setDescription(DESCRIPTION);
        article1.setPrice(PRICE);
        articleService.save(article1);
        
        final String NAME2 = "Addidas Performance Bottle 0.5l";
        final String IMAGE_URL2 = "https://www.sportvision.rs/files/thumbs/files/images/slike_proizvoda/thumbs_600/FM9936_600_600px.jpg";
        final String DESCRIPTION2 = "Sa ovom flašicom - uvek ćete znati koliko tečnosti unosite, zahvaljujući bočnom meraču zapremine koji olakšava praćenje.";
        final Double PRICE2 = 790.0;
        Article article2 = new Article();
        article2.setName(NAME2);
        article2.setImageUrl(IMAGE_URL2);
        article2.setDescription(DESCRIPTION2);
        article2.setPrice(PRICE2);
        articleService.save(article2);
        
        final String NAME3 = "LONSDALE M CORE GLOVE";
        final String IMAGE_URL3 = "https://www.sportvision.rs/files/thumbs/files/images/slike_proizvoda/thumbs_800/762439-03_800_800px.jpg";
        final String DESCRIPTION3 = "Lonsdale otvorene rukavice, idealne za sparing i kikboks treninge, kao i treninge u teretani.";
        final Double PRICE3 = 2840.0;
        Article article3 = new Article();
        article3.setName(NAME3);
        article3.setImageUrl(IMAGE_URL3);
        article3.setDescription(DESCRIPTION3);
        article3.setPrice(PRICE3);
        articleService.save(article3);
        
        final String NAME4 = "RING SPORT SKLEKERI";
        final String IMAGE_URL4 = "https://www.sportvision.rs/files/thumbs/files/images/slike_proizvoda/thumbs_600/RX-PU1205_600_600px.jpg";
        final String DESCRIPTION4 = "Sklekeri za udobniji i pravilniji rad ovog neizbeznog klasika među body-weight vežbama.";
        final Double PRICE4 = 990.0;
        Article article4 = new Article();
        article4.setName(NAME4);
        article4.setImageUrl(IMAGE_URL4);
        article4.setDescription(DESCRIPTION4);
        article4.setPrice(PRICE4);
        articleService.save(article4);
        
        final String NAME5 = "ELLESSE ZIPPER";
        final String IMAGE_URL5 = "https://www.sportvision.rs/files/thumbs/files/images/slike_proizvoda/thumbs_600/ELEQ193405-01_1_600_600px.jpg";
        final String DESCRIPTION5 = "Ellese zipper naočare za skijanje, učiniće da i ovogodišnje zimovanje ostane u dugom sećanju";
        final Double PRICE5 = 2490.0;
        Article article5 = new Article();
        article5.setName(NAME5);
        article5.setImageUrl(IMAGE_URL5);
        article5.setDescription(DESCRIPTION5);
        article5.setPrice(PRICE5);
        article5.setName(NAME5);
        article5.setImageUrl(IMAGE_URL5);
        article5.setDescription(DESCRIPTION5);
        article5.setPrice(PRICE5);
        articleService.save(article5);
        
        final String NAME6 = "BUTTERFLY REKET TB GOLD";
        final String IMAGE_URL6 = "https://www.sportvision.rs/files/thumbs/files/images/slike_proizvoda/thumbs_350/BUTT-85021_350_350px.webp";
        final String DESCRIPTION6 = "Idealan napadački reket iz kompanije sa samog vrha opreme i rekvizita za stoni tenis. Samo za najhrabrije.";
        final Double PRICE6 = 3390.0;
        Article article6 = new Article();
        article6.setName(NAME6);
        article6.setImageUrl(IMAGE_URL6);
        article6.setDescription(DESCRIPTION6);
        article6.setPrice(PRICE6);
        articleService.save(article6);
        
        final String NAME7 = "NIKE 1000 SOFTSET OUTDOOR";
        final String IMAGE_URL7 = "https://www.sportvision.rs/files/thumbs/files/images/slike_proizvoda/thumbs_600/N-000-0068-427-05_600_600px.jpg";
        final String DESCRIPTION7 = "Obavezan deo arsenala svakog ljubitelja odbojke. Za salu i izvan nje.";
        final Double PRICE7 = 2990.0;
        Article article7 = new Article();
        article7.setName(NAME7);
        article7.setImageUrl(IMAGE_URL7);
        article7.setDescription(DESCRIPTION7);
        article7.setPrice(PRICE7);
        articleService.save(article7);
        
        final String NAME8 = "BABOLAT TENISERSKA TORBA TEAM LINE";
        final String IMAGE_URL8 = "https://www.sportvision.rs/files/thumbs/files/images/slike_proizvoda/thumbs_350/164043_350_350px.webp";
        final String DESCRIPTION8 = "Babolat torba Team Line, za lakši transport Vaše omiljene opreme.";
        final Double PRICE8 =  6740.0;
        Article article8 = new Article();
        article8.setName(NAME8);
        article8.setImageUrl(IMAGE_URL8);
        article8.setDescription(DESCRIPTION8);
        article8.setPrice(PRICE8);
        articleService.save(article8);
        
    }
}
