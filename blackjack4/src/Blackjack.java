import java.util.Scanner;
import java.lang.String;

    public class Blackjack {

        public static void main(String[] args) {

            P1Random rng = new P1Random();
            Scanner reader = new Scanner(System.in);
            int count = 1, play = 3, wincount = 0, losecount = 0, tiecount = 0, hand = 0, dealerhand = 0, card = 0, cardval = 0, statgame = 0, n = 1;
            String avg;
            while (true) {



                System.out.println("START GAME #" + count); //Game Counter
                System.out.println(""); //Game Counter
                card = rng.nextInt(13) + 1; //Get card value

                // System.out.println(card); // for debug shows card value
                if (card == 1) {
                    System.out.println("Your card is a ACE!");
                    cardval = 1;
                } else if (card == 13) {
                    System.out.println("Your card is a KING!");
                    cardval = 10;
                } else if (card == 12) {
                    System.out.println("Your card is a QUEEN!");
                    cardval = 10;
                } else if (card == 11) {
                    System.out.println("Your card is a JACK!");
                    cardval = 10;
                } else if (card == 2 | card == 3 | card == 4 | card == 5 | card == 6 | card == 7 | card == 8 | card == 9 | card == 10) {
                    System.out.println("Your card is a " + card + "!");
                    cardval = card;

                }
                hand += cardval; //Add card value to hand
                System.out.println("Your hand is: " + hand);


                if (hand == 21) {
                    System.out.println("BLACKJACK! You Win!");
                    play = 1;
                    hand = 0;
                    break;
                } else if (hand > 21) {
                    System.out.println("You exceeded 21! You Lose.");
                    hand = 0;
                    play = 0;
                    break;
                }





                while (true) {
                    //Prints menu
                    System.out.println("");
                    System.out.println("1. Get another card");
                    System.out.println("2. Hold hand");
                    System.out.println("3. Print statistics");
                    System.out.println("4. Exit");
                    System.out.println("");
                    System.out.print("Choose an option: ");
                    n = reader.nextInt();
                    System.out.println("");



                    if (n == 1) {

                        card = rng.nextInt(13) + 1; //Get card value

                        // System.out.println(card); // for debug shows card value
                        if (card == 1) {
                            System.out.println("Your card is a ACE!");
                            cardval = 1;
                        } else if (card == 13) {
                            System.out.println("Your card is a KING!");
                            cardval = 10;
                        } else if (card == 12) {
                            System.out.println("Your card is a QUEEN!");
                            cardval = 10;
                        } else if (card == 11) {
                            System.out.println("Your card is a JACK!");
                            cardval = 10;
                        } else if (card == 2 | card == 3 | card == 4 | card == 5 | card == 6 | card == 7 | card == 8 | card == 9 | card == 10) {
                            System.out.println("Your card is a " + card + "!");
                            cardval = card;

                        }
                        hand += cardval; //Add card value to hand
                        System.out.println("Your hand is: " + hand);


                        if (hand == 21) {
                            System.out.println("");
                            System.out.println("BLACKJACK! You win!");
                            System.out.println("");

                            play = 1;
                            hand = 0;
                            break;
                        } else if (hand > 21) {
                            System.out.println("");
                            System.out.println("You exceeded 21! You lose.");
                            System.out.println("");
                            hand = 0;
                            play = 0;
                            break;
                        }

                    }


                    if (n == 2) {

                        dealerhand = rng.nextInt(11) + 16;
                        System.out.println("Dealer's hand: "+ dealerhand);
                        System.out.println("Your hand is: "+ hand);
                        if (dealerhand == hand) {
                            System.out.println("");
                            System.out.println("It's a tie! No one wins!");
                            System.out.println("");
                            play = 2;
                            hand = 0;
                            break;
                        }
                        else if (dealerhand > 21) {

                            System.out.println("");

                            System.out.println("You win!");
                            System.out.println("");


                            play = 1;
                            hand = 0;
                            break;

                        } else if (dealerhand > hand) {
                            System.out.println("");
                            System.out.println("Dealer wins!");
                            System.out.println("");


                            play = 0;
                            hand = 0;
                            break;

                        } else if (hand > dealerhand) {
                            System.out.println("You Win!");
                            play = 1;
                            hand = 0;
                            break;
                        }

                    }


                    if (n == 3) {
                        statgame = count - 1; // need this so stats dont count current game
                        System.out.println("Number of Player wins: " + wincount);
                        System.out.println("Number of Dealer wins: " + losecount);
                        System.out.println("Number of tie games: " + tiecount);
                        System.out.println("Total # of games played is: " + statgame); //statgame is total finished games



                        avg = String.format("%.1f", (float) wincount / (float) (statgame) * 100);
                        System.out.println("Percentage of Player wins: " + avg + "%");
                    }
                    if (n == 4) {

                        reader.close();
                        return;
                    } else if (n > 4) {
                        System.out.println("Invalid input!");
                        System.out.println("Please enter an integer value between 1 and 4.");


                    }

                }


                if (play == 1) {        //Tracks wins and losses
                    wincount++;
                } else if (play == 0)
                    losecount++;
                else {
                    tiecount++;
                }

                count = count + 1; //increment game counter

            }

        }
    }
