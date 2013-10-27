import models.SurferDB;
import play.Application;
import play.GlobalSettings;
import views.formdata.SurferFormData;

/**
* Initializes surfers on start up.
* @author Brent Yoshida
*
*/
public class Global extends GlobalSettings {
  /**
* Initializes surfers.
* @param app The application.
*/
  public void onStart(Application app) {
    String mick = "He was also victorious when he took a wild card entry at the Rip Curl Pro at Bells Beach in 2001 winning one of Australia's most acclaimed contests. He finished 2002 as rookie of the year winning the Billabong Pro at Jeffrey's Bay and"
               + "earning himself a slot on the 2002 tour as the World Qualifying Series' (WQS) Champion."
               + "He suffered a complete hamstring tear in 2004. He had to have it surgically repaired and made an incredible comeback to become one of the greatest surfers on the ASP world tour."
               + "The year 2007 marked Fanning's sixth year on the Foster's Association of Surfing Professionals (ASP) World Tour since 2002 and his ninth year on the ASP WQS since 1998. He began his 2007 World Title campaign"
               + "(WCT) with a victory at the Quiksilver Pro, the first event on the Foster's ASP World Tour, putting himself on top of the ratings. He won the Santa Catarina Pro in Brazil on 6 "
               + "November 2007 placing above Taj Burrow and Kelly Slater therefore clinching the 2007 ASP world title.[2] In 2008 he suffered a mid-season groin injury. He slipped to eighth position on the end "
               + "of year ratings. In 2009, Mick Fanning reclaimed his ASP World Champion crown at the famous Pipeline reef break on Oahu窶冱 North Shore. Although Fanning was knocked out by fellow Australian "
               + "Dean Morrison in Round 4, his points lead from winning three of the last four events was enough to secure victory.[5} "
               + "According to an interview with WideWorld magazine, Fanning's favourite surf spots in Australia include Snapper Rocks on the Gold Coast, Bells Beach in Victoria and Gnarloo in Western Australia";
    
    String jake = "Many young surfers have the potential to make an impact on our sport, but none look more poised to do so"
        + " than Jake Marshall. Raised on the rippable beachbreaks and reefs of San Diego North County, Jake has developed "
        + "a solid base of smooth rail work as well as the kind of flair that few 14-year-old surfers can match. His progression "
        + "is due in no small part to the numerous world-class talents in his neighborhood that have taught him a thing or"
        + " two about tearing Seaside apart. see Rob Machado, Josh Kerr, Damien Hobgood, and Taylor Knox out all the time,"
        + " and its really fun to surf with guys on that level look at them and think, thats how I have to surf if I want"
        + " to make the Tour one day.That really helps me push my limits, hes had remarkable success in a jersey, including"
        + " a recent win at the U.S. Surfing Championships at Lower Trestles. But while surf stardom seems inevitable for "
        + "Jake, hes still just a kid, and knows where his priorities should be. surf and try to improve all the time, but "
        + "I still put a lot of emphasis on school, know that education is really important, and if surfing doesnt work out,"
        + " its always good to have a backup plan";

    
    String carissa = "2013, Moore is currently leading the 2013 ASP World Tour women's title race (after 3 events). Moore has won 2 ASP World Tour events in 2013, the Drug Aware Margaret River Pro[7] and the Rip Curl Pro Bells Beach.[8]"
                   + "2012, Moore finished 3rd in the 2012 ASP World Tour, failing to win any ASP World Tour events, coming runner-up in two events."
                   + "2011, Moore was declared the ASP Women World Champion, the youngest winner of the Title.[9] Throughout the 2011 Tour, Moore won the Billabong Rio Pro,[10] Commonwealth Bank Beachley Classic[11] and the Roxy Pro Gold Coast.[12]"
                   + "2010, Moore was incepted into the ASP Women World Tour. During her first year on the Tour Moore won both the TSB Bank Women Surf Festival[13][14] and Rip Curl Pro Portugal.[15] Moore 2010 Women World Tour Ranking was 3rd overall.[16] and she was awarded the ASP Women World Tour Rookie of the Year.[17]"
                   + "Refer to ASP Wildcard Entries section for further information relating Moore's involvement prior to being incepted into the ASP Women World Tour.";
    
    SurferDB.addSurfer(new SurferFormData("Mick Fanning", "2 times ASP World Champion 2007, 2009", "Penrith, New South Wales, Australia",
        "http://upload.wikimedia.org/wikipedia/commons/b/b2/Mick_Fanning.jpg",
        "http://old.lostenterprises.com/dev/images/news/Lost_fanning_Large.jpg",
        mick, "mickfanning", "Male"));
    
    SurferDB.addSurfer(new SurferFormData("Jake Marshall", "Unknown", "Encinitas, CA",
        "http://www.surfingamerica.org/wp-content/uploads/2011/01/JakeMarshall_MG_3530-3.jpg",
        "http://stwww.surfingmagazine.com/wp-content/blogs.dir/1/files/2011/02/JakeMarshall01-677x442.jpg",
        jake, "jakemarshall", "Grom"));
    
    SurferDB.addSurfer(new SurferFormData("Carissa Moore", "2013 ASP World Tour", "Honolulu, Hawaii",
        "http://www.lat34.org/quick_hits/wp-content/uploads/2008/11/moore_c1985reefpro08rowland_m.jpg",
        "http://prettytough.com/wp-content/uploads/2008/11/carissa-moore.jpg",
        carissa, "carissamoore", "Female"));
    
  }
  
}
