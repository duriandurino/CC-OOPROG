import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Players extends Rectangle {

    Random randFall = new Random();// random xpos when respawn

    Audio jomp, matay, dasher, naigo;

    Color color;
    int id;
    int layp;// haha layp

    int r,l, pR, pL;//right left detection

    ImageIcon pimg;
    ImageIcon plf = new ImageIcon("assets/layp.png");
    Image plfi = plf.getImage();
    ImageIcon pfp;

    boolean right = false;
    boolean left = false;
    boolean jump = false;//mobmint bools
    boolean fall = false;
    boolean dash = false;

    boolean topColl = false;//pakong

    boolean alive = true;//game state bools
    boolean died=false;
    private boolean paused = false;
    boolean napaso = false;
    boolean kb=false;//kb state
    boolean rkb=false;//kb dir
    boolean lkb=false;

    double x,y;

    double jspeed=15;
    double currJspeed=jspeed;//jump height

    double dspeed=15;//dash length
    double currDspeed=jspeed;

    double maxFspeed=8;
    double currFspeed=1;//fall speed

    Players(Color color, int id){
        x=400+id*350;//spawn point
        y=400;

        this.width=64;
        this.height=48;
        this.color = color;
        this.id=id;
        this.layp=5;

        jomp=new Audio("assets/jump.wav");//sfx init
        matay=new Audio("assets/died.wav");
        dasher=new Audio("assets/synth.wav");
        naigo=new Audio("assets/hit.wav");
    }

    void tick(Plats[][] pl, Lava lava, Players p){

        boolean prevFall = fall;
        boolean prevJump = jump;
        boolean prevLeft = left;//for when resume
        boolean prevRight = right;
        boolean prevDash = dash;
        boolean prevKb = kb;

        died=false;

        if(Demo.paused){
            this.paused=true;

            fall = false;
            jump=false;
            left=false;
            right=false;
            dash=false;
            kb=false;
        }else if(Demo.resumed){
            this.paused=false;
            fall=prevFall;
            jump=prevJump;
            right=prevRight;
            left=prevLeft;
            dash=prevDash;
            kb=prevKb;
        }

        mobmints(pl, lava, p);
    }

    String file;
    String prevFile = "assets/p"+(id+1)+"r.gif";

    void draw(Graphics g){

        if (alive){
            file=prevFile;
            if(l==0&&r==0){
                file = "assets/p"+(id+1)+"r.gif";
                r=1;
                prevFile=file;
            }
            if(!dash){
                if(right||r==1){
                    file = "assets/p"+(id+1)+"r.gif";
                    prevFile=file;
                }
                if(left||l==1){
                    file = "assets/p"+(id+1)+".gif";
                    prevFile=file;
                }
            }

            if(dash){
                if(r==1){
                    file = "assets/p"+(id+1)+"ar.gif";
                    prevFile=file;
                }
                if(l==1){
                    file = "assets/p"+(id+1)+"a.gif";
                    prevFile=file;
                }
            }

            if (kb) {
                if(rkb){
                    file = "assets/p"+(id+1)+"hr.gif";
                    prevFile=file;
                }
                if(lkb){
                    file = "assets/p"+(id+1)+"h.gif";
                    prevFile=file;
                }
            }

            if(napaso){
                file="assets/napaso.gif";
                prevFile=file;
            }

            pimg = new ImageIcon(file);
            Image plrImg = pimg.getImage();
            g.setColor(color);
            if(dash){
                g.drawImage(plrImg,(int)x,(int)y,width+30,height,null);
            }else{
                g.drawImage(plrImg,(int)x,(int)y,width,height,null);
            }
            //g.fillRect((int)x,(int)y,width,height);
        }
        g.setColor(Color.GRAY);
        g.drawImage(plfi,50+id*880,50,220,100,null);
        pfp=new ImageIcon("assets/pfp"+(id+1)+".gif");
        Image pfpi = pfp.getImage();
        g.drawImage(pfpi, 165+id*880, 80, 100,55, null);
        g.setColor(color);
        String laypp = "x"+layp;
        g.setFont(new Font("Palatino Linotype", Font.BOLD, 55));//for Player life count
        g.drawString(laypp,80+id*880,120);
    }

    void keyPressed(int k){
        if(alive&&!paused&&!dash&&!kb){
            //System.out.println(id+" "+super.x+" : "+x);
            //System.out.println(id+" "+super.y+" : "+y);
            if(id==1){
                if(k== KeyEvent.VK_RIGHT){
                    right=true;
                    r=1;
                    l=0;
                }
                if(k== KeyEvent.VK_LEFT){
                    left=true;
                    r=0;
                    l=1;
                }
                if(k==KeyEvent.VK_SLASH){
                    dash=true;
                    dasher.playSfx();
                    //System.out.println("P2 dash");
                }
                if(k==KeyEvent.VK_UP&&!jump&&!fall){jomp.playSfx();jump=true;}
            }
            if(id==0){
                if(k== KeyEvent.VK_D){
                    right=true;
                    r=1;
                    l=0;
                }
                if(k== KeyEvent.VK_A){
                    left=true;
                    r=0;
                    l=1;
                }
                if(k==KeyEvent.VK_F){
                    dash=true;
                    dasher.playSfx();
                    //System.out.println("P1 dash");
                }
                if(k==KeyEvent.VK_W&&!jump&&!fall){jomp.playSfx();jump=true;}
            }
        }
        //System.out.println(l+" : "+r);
    }

    void keyTyped(char k){

    }//yosless pesashit pero basin ma yospul idk

    void keyReleased(int k){
        if(alive&&!paused){
            if(id==1){
                if(k== KeyEvent.VK_RIGHT){right=false;}
                if(k== KeyEvent.VK_LEFT){left=false;}
            }
            if(id==0){
                if(k== KeyEvent.VK_D){right=false;}
                if(k== KeyEvent.VK_A){left=false;}
            }
        }
    }

    //BUKOT2 STARTS HERE

    void mobmints(Plats[][] pl, Lava lava, Players p){

        int iX = (int)x;
        int iY = (int)y;

        if(!paused&&alive){
            if(y>800){
                died=true;
            }
            if (layp <= 0){
                //System.out.println("Player "+(id+1)+" is ded");
                alive = false;
                fall=false;
                x = 0;
                y = 0;
            }

            if(Collision.coll(new Point(iX+2,iY+height+1),lava)
                    || Collision.coll(new Point(iX+width-1, iY+height+1),lava)){
                //y=lava.getY()-height;
                //System.out.println("Napaso Lava");
                napaso=true;
                died=true;
            }

            if(right){
                x+=6;
            }
            if(left){
                x-=6;
            }

            dashing();//dashing through the snow
            plColl(pl, iX, iY);//platform coll
            jumping();//ambakukam
            falling();//nahug haha

            if(died){
                dead();
                layp--;
            }
        }
    }

    void dead(){
        matay.playSfx();
        kb=false;
        x=randFall.nextInt(600)+300;
        y=-1000;
        napaso=false;
    }

    void jumping(){
        if(jump){

            y-=currJspeed;
            currJspeed-=1;
            //System.out.println("Jump: "+y+" "+currJspeed);

            if(currJspeed<=0){
                currJspeed=jspeed;
                jump=false;
                fall=true;
            }
        }
    }

    void falling(){
        if(fall){
            y+=currFspeed;
            //System.out.println("Fall: "+y+" "+currFspeed);
            if(currFspeed<maxFspeed){
                currFspeed+=1;
            }
        }
        if(!fall){
            currFspeed=1;
        }
    }

    void dashing(){
        if(dash){

            if (r==1) {
                x+=currDspeed;
                currDspeed-=1;
                pR=1;
                pL=0;
                //System.out.println("Jump: "+y+" "+currJspeed);
                if(currDspeed<=0){
                    currDspeed=dspeed;
                    dash=false;
                }
            }
            if(l==1){
                x-=currDspeed;
                currDspeed-=1;
                pL=1;
                pR=0;
                //System.out.println("Jump: "+y+" "+currJspeed);

                if(currDspeed<=0){
                    currDspeed=dspeed;
                    dash=false;
                }
            }
        }
    }

    void hit(boolean r){
        //System.out.println("MA NAKBAK NING BOANG P"+(id+1));
        double kspeed=6;
        double currKspeed=kspeed;
        if(r){
            this.x+=currKspeed;
            rkb=true;
        }else{
            this.x-=currKspeed;
            lkb=true;
        }

        currKspeed-=1;

        if(currKspeed<=0){
            currKspeed=kspeed;
            kb=false;
            rkb=false;
            lkb=false;
        }
    }

    void plColl(Plats[][] pl, int iX, int iY){
        for(int i=0; i<pl.length;i++){
            for(int j=0;j<pl[0].length;j++){
                if(Collision.coll(new Point(iX+width,iY+2),pl[i][j])
                        || Collision.coll(new Point(iX+width, iY+height-1),pl[i][j])){
                    //System.out.println("Right");
                    right=false;
                    dash=false;
                    kb=false;
                }
                if(Collision.coll(new Point(iX-1,iY+2),pl[i][j])
                        || Collision.coll(new Point(iX-1, iY+height-1),pl[i][j])){
                    //System.out.println("Left");
                    left=false;
                    dash=false;
                    kb=false;
                }
                if(Collision.coll(new Point(iX+1,iY),pl[i][j])
                        || Collision.coll(new Point(iX+width-1, iY),pl[i][j])){
                    //System.out.println("Pakong");
                    jump=false;
                }
                if(Collision.coll(new Point(iX+2,iY+height+1),pl[i][j])
                        || Collision.coll(new Point(iX+width-1, iY+height+1),pl[i][j])){
                    if(!napaso){
                        y=pl[i][j].getY()-height;
                    }
                    //System.out.println("Floor");
                    fall=false;
                    topColl=true;
                }else{
                    if(!topColl&&!jump&&alive){
                        fall=true;
                    }
                }//if no coll then fall
            }
        }
        topColl=false;
    }
}
