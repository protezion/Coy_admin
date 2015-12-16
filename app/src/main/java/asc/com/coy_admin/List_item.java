package asc.com.coy_admin;

/**
 * Created by THE KWON on 2015-12-12.
 */

public class List_item {
    String objectId;
    String clubIntro;
    String clubLeader;
    String clubLotate;
    String clubName;
    String clubPhone;
    String clubSub;

    String getObjectId() { return this.objectId; }
    String getClubIntro() { return this.clubIntro; }
    String getClubLeader() { return this.clubLeader; }
    String getClubLotate() { return this.clubLotate; }
    String getClubName(){
        return this.clubName;
    }
    String getClubSub() { return this.clubSub; }
    String getClubPhone() { return this.clubPhone; }


    List_item(String objectId, String clubIntro,  String clubLeader, String clubLotate,
              String clubName, String clubPhone, String clubSub) {

        this.objectId = objectId;
        this.clubIntro = clubIntro;
        this.clubLeader = clubLeader;
        this.clubLotate = clubLotate;
        this.clubName = clubName;
        this.clubPhone = clubPhone;
        this.clubSub = clubSub;
    }

}
