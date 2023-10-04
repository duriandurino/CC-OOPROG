class Guns{

    String name;
    int damage;
    int bullets;
    
    Guns(String name, int damage, int bullets){
        this.name = name;
        this.damage = damage;
        this.bullets = bullets;
    }

    void displayGun(){
        System.out.println("Gun: "+name+"\nDamage: "+damage+"\nAmmo Size: "+bullets);
    }

}

class test{

    public static void main(String[] args){
        //System.out.println("Hello Hello");
        Guns gun = new Guns("no name", 0, 0);
        Guns AK47 = new Guns("Kalashnikov", 40, 30);

        gun.displayGun();
        AK47.displayGun();
    }

}