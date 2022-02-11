/*
 * Filename: project2_jah0147.cpp
 * Project Description : This is a Duel Simulator with 3 players. The code
 *  will simulate different outcomes based on the players shot accuracy and strategy.
 * Author: Jacob Howard
 *
 * I received help with this project
 */

# include <iostream>
# include <cassert>
# include <cstdlib>
# include <ctime>

//Function to check if at least two players are alive
bool at_least_two_alive(bool aaron_alive, bool bob_alive, bool charlie_alive){
    return (aaron_alive && bob_alive || aaron_alive && charlie_alive || bob_alive && charlie_alive );
}

//Aarons first stratagy
void aaron_shoots_1(bool& bob_alive, bool& charlie_alive) {
    int hitrate = 33;
    int random_number = rand()%100;

    //Tests if aaron hits based on hit percentage of 1/3
    if (random_number <= 33.33) {
        if (charlie_alive) {
            charlie_alive = false;
        } else {
            bob_alive = false;
        }
    }

}

//Bob shoot accuracy at 50%
void bob_shoots_1 (bool& aaron_alive, bool& charlie_alive) {
    int hitrate = 50;
    int random_number = rand()%100;
    if (random_number >= 50) {
        if (charlie_alive) {
            charlie_alive = false;
        }
        else {
            aaron_alive = false;
        }
    }
}

//Charlie shoot accuracy at 100%
void charlie_shoots_1 (bool& aaron_alive, bool& bob_alive) {
    if (bob_alive) {
        bob_alive = false;
    } else {
        aaron_alive = false;
    }
}

//Aaron's second strategy
void aaron_shoots_2(bool& bob_alive, bool& charlie_alive) {
    int hitrate = 33;
    int random = rand()%100;
    if (charlie_alive && bob_alive) {
        //Do nothing
    }
    else {
        aaron_shoots_1(bob_alive, charlie_alive);
    }
}
int aaron_wins = 0;
int bob_wins = 0;
int charlie_wins = 0;

//Strategy one for Aaron shooting
void stratagy_1() {
 bool aaron_alive = true;
 bool bob_alive = true;
 bool charlie_alive = true;
 while (at_least_two_alive(aaron_alive, bob_alive, charlie_alive)) {
     if (aaron_alive) {
         aaron_shoots_1(bob_alive, charlie_alive);
     }
     if (bob_alive) {
         bob_shoots_1(aaron_alive, charlie_alive);
     }
     if (charlie_alive) {
         charlie_shoots_1(aaron_alive, bob_alive);
     }
 }

 //Checks who wins
 if (aaron_alive) {
     aaron_wins ++;
 } else if (bob_alive){
     bob_wins++;
 }
 else if (charlie_alive){
     charlie_wins++;
 }
}

//Strategy 2 for Aaron
void stratagy_2() {

    bool aaron_alive = true;
    bool bob_alive = true;
    bool charlie_alive = true;
    while (at_least_two_alive(aaron_alive, bob_alive, charlie_alive)) {
        if (aaron_alive) {
            aaron_shoots_2(bob_alive, charlie_alive);
        }
        if (bob_alive) {
            bob_shoots_1(aaron_alive, charlie_alive);
        }
        if (charlie_alive) {
            charlie_shoots_1(aaron_alive, bob_alive);
        }
    }

    //Checks who wins
    if (aaron_alive) {
        aaron_wins ++;
    } else if (bob_alive){
        bob_wins++;
    }
    else if (charlie_alive){
        charlie_wins++;
    }
}

//Testing at least two people alive (Unit 1)
void test_at_least_two_alive(void) {
    std::cout << "Unit Testing 1: Function –at_least_two_alive()\n";
    std::cout << "\tCase 1: Aaron alive, Bob alive, Charlie alive\n";
    assert(true == at_least_two_alive(true, true, true));
    std::cout << "\tCase passed ...\n";
    std::cout << "\tCase 2: Aaron dead, Bob alive, Charlie alive\n";
    assert(true == at_least_two_alive(false, true, true));
    std::cout << "\tCase passed ...\n";
    std::cout << "\tCase 3: Aaron alive, Bob dead, Charlie alive\n";
    assert(true == at_least_two_alive(true, false, true));
    std::cout << "\tCase passed ...\n";
    std::cout << "\tCase 4: Aaron alive, Bob alive, Charlie dead\n";
    assert(true == at_least_two_alive(true, true, false));
    std::cout << "\tCase passed ...\n";
    std::cout << "\tCase 5: Aaron dead, Bob dead, Charlie alive\n";
    assert(false == at_least_two_alive(false, false, true));
    std::cout << "\tCase passed ...\n";
    std::cout << "\tCase 6: Aaron dead, Bob alive, Charlie dead\n";
    assert(false == at_least_two_alive(false, true, false));
    std::cout << "\tCase passed ...\n";
    std::cout << "\tCase 7: Aaron alive, Bob dead, Charlie dead\n";
    assert(false == at_least_two_alive(true, false, false));
    std::cout << "\tCase passed ...\n";
    std::cout << "\tCase 8: Aaron dead, Bob dead, Charlie dead\n";
    assert(false == at_least_two_alive(false, false, false));
    std::cout << "\tCase passed ...\n";
}

//Testing aaron shoots 1 case (Unit 2)
void aaron_shoots_1_test() {
    std::cout<<"Unit Testing 2: Function Aaron_shoots1(Bob_alive, Charlie_alive)\n";

    //Testing Case 1
    std::cout<<"\tCase 1: Bob alive, Charlie alive\n";
    bool bob_alive = true;
    bool charlie_alive = true;
    assert(true == bob_alive);
    aaron_shoots_1(bob_alive, charlie_alive);
    std::cout<<"\t \tAaron is shooting at Charlie\n";
    if (charlie_alive) {
        std::cout<<"\t \t \tOutcome: Charlie lived\n";
    } else {
        std::cout<<"\t \t \tOutcome: Charlie died ...\n";
    }

    //Testing Case 2
    std::cout<<"\tCase 2: Bob dead, Charlie alive\n";
    bob_alive = false;
    charlie_alive = true;
    assert(false == bob_alive);
    aaron_shoots_1(bob_alive, charlie_alive);
    std::cout<<"\t \tAaron is shooting at Charlie\n";
    if (charlie_alive) {
        std::cout<<"\t \t \tOutcome: Charlie lived\n";
    } else {
        std::cout<<"\t \t \tOutcome: Charlie died ...\n";
    }

    //Testing Case 3
    std::cout<<"\tCase 3: Bob alive, Charlie dead\n";
    bob_alive = true;
    charlie_alive = false;
    assert(false == charlie_alive);
    aaron_shoots_1(bob_alive, charlie_alive);
    std::cout<<"\t \tAaron is shooting at Bob\n";
    if (bob_alive) {
        std::cout<<"\t \t \tOutcome: Bob lived\n";
    } else {
        std::cout<<"\t \t \tOutcome: Bob died...\n";
    }

}

//Testing Bob shoots (Unit 3)
void bob_shoots_1_test() {
    std::cout<<"Unit Testing 3: Function Bob_shoots(Aaron_alive, Charlie_alive)\n";

    //Testing Case 1
    bool  aaron_alive = true;
    bool charlie_alive = true;
    std::cout<<"\tCase 1: Aaron alive, Charlie alive\n";
    assert(true == aaron_alive);
    bob_shoots_1(aaron_alive, charlie_alive);
    std::cout<<"\t \tBob is shooting at Charlie\n";
    if (charlie_alive) {
        std::cout<<"\t \t \tOutcome: Charlie lived\n";
    } else {
        std::cout<<"\t \t \tOutcome: Charlie died ...\n";
    }

    //Testing Case 2
    std::cout<<"\tCase 2: Aaron dead, Charlie alive\n";
    aaron_alive = false;
    charlie_alive = true;
    assert(false == aaron_alive);
    bob_shoots_1(aaron_alive, charlie_alive);
    std::cout<<"\t \tBob is shooting at Charlie\n";
    if (charlie_alive) {
        std::cout<<"\t \t \tOutcome: Charlie lived\n";
    } else {
        std::cout<<"\t \t \tOutcome: Charlie died ...\n";
    }

    //Testing Case 3
    std::cout<<"\tCase 3: Aaron alive, Charlie dead\n";
    aaron_alive = true;
    charlie_alive = false;
    assert(false == charlie_alive);
    bob_shoots_1(aaron_alive, charlie_alive);
    std::cout<<"\t \tAaron is shooting at Bob\n";
    if (aaron_alive) {
        std::cout<<"\t \t \tOutcome: Aaron lived\n";
    } else {
        std::cout<<"\t \t \tOutcome: Aaron died...\n";
    }

}

//Testing Charlie's shot
void charlie_shoots_1_test() {
    std::cout<<"Unit Testing 4: Function Charlie_shoots(Aaron_alive, Bob_alive)\n";

    //Testing Case 1
    bool  aaron_alive = true;
    bool bob_alive = true;
    std::cout<<"\tCase 1: Aaron alive, Bob alive\n";
    assert(true == bob_alive);
    charlie_shoots_1(aaron_alive, bob_alive);
    std::cout<<"\t \tCharlie is shooting at Bob\n";
    if (bob_alive) {
        std::cout<<"\t \t \tOutcome: Bob lived\n";
    } else {
        std::cout<<"\t \t \tOutcome: Bob died ...\n";
    }

    //Testing Case 2
    std::cout<<"\tCase 2: Aaron dead, Bob alive\n";
    aaron_alive = false;
    bob_alive = true;
    assert(false == aaron_alive);
    charlie_shoots_1(aaron_alive, bob_alive);
    std::cout<<"\t \tCharlie is shooting at Bob\n";
    if (bob_alive) {
        std::cout<<"\t \t \tOutcome: Bob lived\n";
    } else {
        std::cout<<"\t \t \tOutcome: Bob died ...\n";
    }

    //Testing Case 3
    std::cout<<"\tCase 3: Aaron alive, Bob dead\n";
    aaron_alive = true;
    bob_alive = false;
    assert(false == bob_alive);
    charlie_shoots_1(aaron_alive, bob_alive);
    std::cout<<"\t \tCharlie is shooting at Aaron\n";
    if (aaron_alive) {
        std::cout<<"\t \t \tOutcome: Aaron lived\n";
    } else {
        std::cout<<"\t \t \tOutcome: Aaron died...\n";
    }

}

//Testing Aarons second strategy (Unit 5)
void aaron_shoots_2_test() {
    std::cout<<"Unit Testing 5: Function Aaron_shoots2(Bob_alive, Charlie_alive)\n";

    //Case 1 Test
    bool bob_alive = true;
    bool  charlie_alive = true;
    std::cout<<"\tCase 1: Bob alive, Charlie alive\n";
    aaron_shoots_2(bob_alive, charlie_alive);
    std::cout<<"\t \tAaron intentionally misses his first shot\n"
               "\t \tBoth Bob and Charlie are alive.\n";
    assert(true == bob_alive);
    if (charlie_alive) {
        //std::cout<<"\t \t \tOutcome: Charlie lived\n";
    } else {
        std::cout<<"\t \t \tOutcome: Charlie died (Something went wrong...)\n";
    }

    //Case 2 Test
    std::cout<<"\tCase 2: Bob dead, Charlie alive\n";
    bob_alive = false;
    charlie_alive = true;
    aaron_shoots_2(bob_alive, charlie_alive);
    std::cout<<"\t \tAaron is shooting at Charlie\n";
    assert(false == bob_alive);
    if (charlie_alive) {
        std::cout<<"\t \t \tOutcome: Charlie lived\n";
    } else {
        std::cout<<"\t \t \tOutcome: Charlie died ...\n";
    }

    //Case 3 Test
    std::cout<<"\tCase 3: Bob alive, Charlie dead\n";
    bob_alive = true;
    charlie_alive = false;
    aaron_shoots_2(bob_alive, charlie_alive);
    std::cout<<"\t \tAaron is shooting at Bob\n";
    assert(false == charlie_alive);
    if (bob_alive) {
        std::cout<<"\t \t \tOutcome: Bob lived\n";
    } else {
        std::cout<<"\t \t \tOutcome: Bob died...\n";
    }
}


int main() {

    srand(time(0));

    //Number Format
    std::cout.setf(std::ios::fixed);
    std::cout.setf(std::ios::showpoint);
    std::cout.precision(2);


    //Start of Duel Simulator
    std::cout<<"*** Welcome to Jacob's Duel Simulator ***\n";

    //Shows test for at least two players alive
    test_at_least_two_alive(); //Case 1
    std::cout << "Press Enter to continue...";
    //Pause Command for Linux Terminal
    std::cin.get();
    std::cout<<"\n"; //Adds a space

    //Shows test for aaron shoot 1
    aaron_shoots_1_test(); //Case 2
    std::cout << "Press Enter to continue...";
    std::cin.get(); //Pause Command for Linux Terminal
    std::cout<<"\n"; //Adds a space

    //Shows test for bob shoot 1
    bob_shoots_1_test(); //Case 3
    std::cout << "Press Enter to continue...\n";
    std::cin.get(); //Pause Command for Linux Terminal
    //std::cout<<"\n"; //Adds a space

    //Shows test for charlie shoot 1
    charlie_shoots_1_test(); //Case 4
    std::cout << "Press Enter to continue...\n";
    std::cin.get(); //Pause Command for Linux Terminal
    //std::cout<<"\n"; //Adds a space

    //Shows test for aaron shoot 2
    aaron_shoots_2_test(); //Case 5
    std::cout << "Press Enter to continue...\n";
    std::cin.get(); //Pause Command for Linux Terminal
    //std::cout<<"\n"; //Adds a space

    //While loop to run the code 10,000 times (Strategy 1)
    std::cout<<"Ready to test strategy 1 (run 10000 times):\n";
    std::cout<<"Press Enter to continue...";
    std::cin.get(); //Pause Command for Linux Terminal
    std::cout<<"\n"; //Adds a space

    int i = 1;
    while (i <= 10000) {
        stratagy_1();
        i++;
    }

    //Prints percentage for Stratagy 1
    double aaron_wins_percent = (double)(1.00 * aaron_wins) / 100; //Casting double to int to make percentage more accurate
    double bob_win_percent = (double)(1.00 * bob_wins) / 100;
    double charlie_win_percent = (double)(1.00 * charlie_wins) / 100;

    //Prints the win percentages for strategy 1
    std::cout<<"Aaron won "<< aaron_wins<<"/10000 duels or "<< aaron_wins_percent<<"%\n";
    std::cout<<"Bob won "<< bob_wins<<"/10000 duels or "<< bob_win_percent<<"%\n";
    std::cout<<"Charlie won "<< charlie_wins<<"/10000 duels or "<< charlie_win_percent<<"%\n";

    //Start Strategy 2
    std::cout<<"\n"; //adds space
    std::cout<<"Ready to test strategy 2 (run 10000 times):\n";
    std::cout << "Press Enter to continue...\n";
    std::cin.get(); //Pause Command for Linux Terminal
    std::cout<<"\n"; //Adds a space

    //While loop for strategy 2
    int n = 1;
    aaron_wins = 0;
    bob_wins = 0;
    charlie_wins = 0;
    while (n <= 10000) {
        stratagy_2();
        n++;
    }

    //Win percentage calculations
    double aaron_wins_percent_2 = (double)(1.00 * aaron_wins) / 100;
    double bob_win_percent_2 = (double)(1.00 * bob_wins) / 100;
    double charlie_win_percent_2 = (double)(1.00 * charlie_wins) / 100;

    //Prints the outcome of strategy 2
    std::cout<<"Aaron won "<<aaron_wins<<"/10000 duels or "<<aaron_wins_percent_2<<"%\n";
    std::cout<<"Bob won "<<bob_wins<<"/10000 duels or "<<bob_win_percent_2<<"%\n";
    std::cout<<"Charlie won "<<charlie_wins<<"/10000 duels or "<<charlie_win_percent_2<<"%\n";

    //Calculates whether stratagy 1 or 2 is better for aaron
    std::cout<<"\n"; //Adds a space
    if (aaron_wins_percent == aaron_wins_percent_2) {
        std::cout<<"Strategy 1 is equal to strategy 2\n";
    } else if (aaron_wins_percent > aaron_wins_percent_2) {
        std::cout<<"Strategy 1 is better than Strategy 2\n";
    } else if (aaron_wins_percent < aaron_wins_percent_2) {
        std::cout<<"Strategy 2 is better than strategy 1\n";
    }

    return 0;
}