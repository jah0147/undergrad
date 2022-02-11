`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company:
// Engineer:
//
// Create Date: 04/09/2021 04:02:52 PM
// Design Name:
// Module Name: LabFinal
// Project Name:
// Target Devices:
// Tool Versions:
// Description:
//
// Dependencies:
//
// Revision:
// Revision 0.01 - File Created
// Additional Comments:
//
//////////////////////////////////////////////////////////////////////////////////


module LabFinal_NoDisplay(
input start,
input reset,
input clkIn, //clock input 1
//input clk,

//output reg [11:0] timer, //full time value
output reg [7:0] AN, //Output for 7-seg display constraints
output reg [6:0] seg0, //7 segment display
output reg [5:0] milliseconds = 6'b000000, 
output reg [5:0] seconds = 6'b000000,
output reg clockDiv_out
);
//(* DONT_TOUCH = "TRUE" *) 
//reg [5:0] seconds, milliseconds;
reg[27:0] counter=28'd0;
parameter DIVISOR = 28'd5000000;
integer a;
wire clk;
wire lock;
//clk_wiz_1 inst2 (.clk_in1(clkIn), .clk_out1(clk), .locked(lock));
//reg [5:0] milliseconds, seconds; //placeholders for seconds and milliseconds
reg [2:0] state, nextstate;
parameter [2:0] Reset=0, Start=1, Milliseconds=2, Seconds=3, Delay=4; //states for start, stop, and reset
//(* DONT_TOUCH = "TRUE" *) reg [5:0] milliseconds;

/*
//clock divider
always @(posedge clk)
begin
 counter <= counter + 28'd1;
 if(counter>=(DIVISOR-1))
  counter <= 28'd0;
 clockDiv_out <= (counter<DIVISOR/2)?1'b1:1'b0;
end
*/
//Main
always @ (posedge clkIn)
state <= nextstate;

always @(state or start or reset)
begin
    nextstate = 1'b0;

    case(state)
        Reset: if (reset) //Reset State
        begin
            milliseconds = 6'b000000; //resets milliseconds placeholder to 0
            seconds = 6'b000000; //resets seconds placeholder to 0
            //timer = 12'b000000000000; //resets the time to 00:00
            nextstate = Start;
        end
        else
        nextstate = Start;

        Start: if (start) //Start Case
            begin
            nextstate = Milliseconds;
            end
            else
            begin
            nextstate = Reset;
            end
        Milliseconds: if (milliseconds < 6'b111100)
                    begin
                   milliseconds = milliseconds + 1; //adding 1 millisecond
                    //timer [5:0] = milliseconds; //setting first 6 bits of timer to milliseconds time
                    nextstate = Reset; //Goes to decoder
                    end
                    else
                    begin
                    nextstate = Seconds;
                    end
         Seconds: if (seconds < 6'b111100)
                    begin
                        milliseconds = 0; //resets milliseconds to zero
                        seconds = seconds + 1; //adding to seconds if milli = 60
                        
                        nextstate = Reset; //Goes to decoder
                    end
                 else //may support more than 1 minute if coded here
                 begin
                 milliseconds = 6'b000000;
                 seconds = 6'b000000;
                 nextstate = Reset; //For now, if one minute hits, we stop
            end
          
              /*  
            Decoder1:  //Decoder state. Decodes binary to 7-segment displays
                begin
                AN = 8'b11111110; //first 7-segment display
                                case(milliseconds)
                                        //0-9
                                    0   :seg0=7'b0000001;
                                    1   :seg0=7'b1001111;
                                    2   :seg0=7'b0010010;
                                    3   :seg0=7'b0000110;
                                    4   :seg0=7'b1001100;
                                    5   :seg0=7'b0100100;
                                    6   :seg0=7'b0100000;
                                    7   :seg0=7'b0001111;
                                    8   :seg0=7'b0000000;
                                    9   :seg0=7'b0000100;
                                    //10-19
                                    10   :seg0=7'b0000001;
                                    11   :seg0=7'b1001111;
                                    12   :seg0=7'b0010010;
                                    13   :seg0=7'b0000110;
                                    14   :seg0=7'b1001100;
                                    15   :seg0=7'b0100100;
                                    16   :seg0=7'b0100000;
                                    17   :seg0=7'b0001111;
                                    18   :seg0=7'b0000000;
                                    19   :seg0=7'b0000100;
                                    //20-29
                                    20   :seg0=7'b0000001;
                                    21   :seg0=7'b1001111;
                                    22   :seg0=7'b0010010;
                                    23   :seg0=7'b0000110;
                                    24   :seg0=7'b1001100;
                                    25   :seg0=7'b0100100;
                                    26   :seg0=7'b0100000;
                                    27   :seg0=7'b0001111;
                                    28   :seg0=7'b0000000;
                                    29   :seg0=7'b0000100;
                                    //30-39
                                    30   :seg0=7'b0000001;
                                    31   :seg0=7'b1001111;
                                    32   :seg0=7'b0010010;
                                    33   :seg0=7'b0000110;
                                    34   :seg0=7'b1001100;
                                    35   :seg0=7'b0100100;
                                    36   :seg0=7'b0100000;
                                    37   :seg0=7'b0001111;
                                    38   :seg0=7'b0000000;
                                    39   :seg0=7'b0000100;
                                    //40-49
                                    40   :seg0=7'b0000001;
                                    41   :seg0=7'b1001111;
                                    42   :seg0=7'b0010010;
                                    43   :seg0=7'b0000110;
                                    44   :seg0=7'b1001100;
                                    45   :seg0=7'b0100100;
                                    46   :seg0=7'b0100000;
                                    47   :seg0=7'b0001111;
                                    48   :seg0=7'b0000000;
                                    49   :seg0=7'b0000100;
                                    //50-59
                                    50   :seg0=7'b0000001;
                                    51   :seg0=7'b1001111;
                                    52   :seg0=7'b0010010;
                                    53   :seg0=7'b0000110;
                                    54   :seg0=7'b1001100;
                                    55   :seg0=7'b0100100;
                                    56   :seg0=7'b0100000;
                                    57   :seg0=7'b0001111;
                                    58   :seg0=7'b0000000;
                                    59   :seg0=7'b0000100;
                                    //default
                                    default: seg0=7'bx;
                                endcase
                
                nextstate = Decoder2; //Must loop back to start state
                end
                
                Decoder2:
                begin
                AN = 8'b11111101;
                                case(seconds)
                                    0   :seg0=7'b0000001;
                                    1   :seg0=7'b0000001;
                                    2   :seg0=7'b0000001;
                                    3   :seg0=7'b0000001;
                                    4   :seg0=7'b0000001;
                                    5   :seg0=7'b0000001;
                                    6   :seg0=7'b0000001;
                                    7   :seg0=7'b0000001;
                                    8   :seg0=7'b0000001;
                                    9   :seg0=7'b0000001;
                                    //10-19
                                    10   :seg0=7'b1001111;
                                    11   :seg0=7'b1001111;
                                    12   :seg0=7'b1001111;
                                    13   :seg0=7'b1001111;
                                    14   :seg0=7'b1001111;
                                    15   :seg0=7'b1001111;
                                    16   :seg0=7'b1001111;
                                    17   :seg0=7'b1001111;
                                    18   :seg0=7'b1001111;
                                    19   :seg0=7'b1001111;
                                    //20-29
                                    20   :seg0=7'b0010010;
                                    21   :seg0=7'b0010010;
                                    22   :seg0=7'b0010010;
                                    23   :seg0=7'b0010010;
                                    24   :seg0=7'b0010010;
                                    25   :seg0=7'b0010010;
                                    26   :seg0=7'b0010010;
                                    27   :seg0=7'b0010010;
                                    28   :seg0=7'b0010010;
                                    29   :seg0=7'b0010010;
                                    //30-39
                                    30   :seg0=7'b0000110;
                                    31   :seg0=7'b0000110;
                                    32   :seg0=7'b0000110;
                                    33   :seg0=7'b0000110;
                                    34   :seg0=7'b0000110;
                                    35   :seg0=7'b0000110;
                                    36   :seg0=7'b0000110;
                                    37   :seg0=7'b0000110;
                                    38   :seg0=7'b0000110;
                                    39   :seg0=7'b0000110;
                                    //40-49
                                    40   :seg0=7'b1001100;
                                    41   :seg0=7'b1001100;
                                    42   :seg0=7'b1001100;
                                    43   :seg0=7'b1001100;
                                    44   :seg0=7'b1001100;
                                    45   :seg0=7'b1001100;
                                    46   :seg0=7'b1001100;
                                    47   :seg0=7'b1001100;
                                    48   :seg0=7'b1001100;
                                    49   :seg0=7'b1001100;
                                    //50-59
                                    50   :seg0=7'b0100100;
                                    51   :seg0=7'b0100100;
                                    52   :seg0=7'b0100100;
                                    53   :seg0=7'b0100100;
                                    54   :seg0=7'b0100100;
                                    55   :seg0=7'b0100100;
                                    56   :seg0=7'b0100100;
                                    57   :seg0=7'b0100100;
                                    58   :seg0=7'b0100100;
                                    59   :seg0=7'b0100100;
                                    default: seg0=7'bx;
                                endcase
                                nextstate = Reset;
                end
                
        Delay: if ( a<100)
        begin
          a = a+1;
          nextstate = Delay;
        end 
        else
        begin
        a = 0;
        nextstate = Decoder1;
        end
        
*/
   endcase
end

/* Decoder 
always @(milliseconds)
        begin
            if (clkIn)
            begin
            /* Millisecond Decoder (1's place) *
                AN = 8'b11111110; //first 7-segment display
                case(milliseconds)
                        //0-9
                    0   :seg0=7'b0000001;
                    1   :seg0=7'b1001111;
                    2   :seg0=7'b0010010;
                    3   :seg0=7'b0000110;
                    4   :seg0=7'b1001100;
                    5   :seg0=7'b0100100;
                    6   :seg0=7'b0100000;
                    7   :seg0=7'b0001111;
                    8   :seg0=7'b0000000;
                    9   :seg0=7'b0000100;
                    //10-19
                    10   :seg0=7'b0000001;
                    11   :seg0=7'b1001111;
                    12   :seg0=7'b0010010;
                    13   :seg0=7'b0000110;
                    14   :seg0=7'b1001100;
                    15   :seg0=7'b0100100;
                    16   :seg0=7'b0100000;
                    17   :seg0=7'b0001111;
                    18   :seg0=7'b0000000;
                    19   :seg0=7'b0000100;
                    //20-29
                    20   :seg0=7'b0000001;
                    21   :seg0=7'b1001111;
                    22   :seg0=7'b0010010;
                    23   :seg0=7'b0000110;
                    24   :seg0=7'b1001100;
                    25   :seg0=7'b0100100;
                    26   :seg0=7'b0100000;
                    27   :seg0=7'b0001111;
                    28   :seg0=7'b0000000;
                    29   :seg0=7'b0000100;
                    //30-39
                    30   :seg0=7'b0000001;
                    31   :seg0=7'b1001111;
                    32   :seg0=7'b0010010;
                    33   :seg0=7'b0000110;
                    34   :seg0=7'b1001100;
                    35   :seg0=7'b0100100;
                    36   :seg0=7'b0100000;
                    37   :seg0=7'b0001111;
                    38   :seg0=7'b0000000;
                    39   :seg0=7'b0000100;
                    //40-49
                    40   :seg0=7'b0000001;
                    41   :seg0=7'b1001111;
                    42   :seg0=7'b0010010;
                    43   :seg0=7'b0000110;
                    44   :seg0=7'b1001100;
                    45   :seg0=7'b0100100;
                    46   :seg0=7'b0100000;
                    47   :seg0=7'b0001111;
                    48   :seg0=7'b0000000;
                    49   :seg0=7'b0000100;
                    //50-59
                    50   :seg0=7'b0000001;
                    51   :seg0=7'b1001111;
                    52   :seg0=7'b0010010;
                    53   :seg0=7'b0000110;
                    54   :seg0=7'b1001100;
                    55   :seg0=7'b0100100;
                    56   :seg0=7'b0100000;
                    57   :seg0=7'b0001111;
                    58   :seg0=7'b0000000;
                    59   :seg0=7'b0000100;
                    //default
                    default: seg0=7'bx;
                endcase
            end
        else
            begin
                /* Millisecond Decoder (10's place) *
                AN = 8'b11111101;
                case(seconds)
                    0   :seg0=7'b0000001;
                    1   :seg0=7'b0000001;
                    2   :seg0=7'b0000001;
                    3   :seg0=7'b0000001;
                    4   :seg0=7'b0000001;
                    5   :seg0=7'b0000001;
                    6   :seg0=7'b0000001;
                    7   :seg0=7'b0000001;
                    8   :seg0=7'b0000001;
                    9   :seg0=7'b0000001;
                    //10-19
                    10   :seg0=7'b1001111;
                    11   :seg0=7'b1001111;
                    12   :seg0=7'b1001111;
                    13   :seg0=7'b1001111;
                    14   :seg0=7'b1001111;
                    15   :seg0=7'b1001111;
                    16   :seg0=7'b1001111;
                    17   :seg0=7'b1001111;
                    18   :seg0=7'b1001111;
                    19   :seg0=7'b1001111;
                    //20-29
                    20   :seg0=7'b0010010;
                    21   :seg0=7'b0010010;
                    22   :seg0=7'b0010010;
                    23   :seg0=7'b0010010;
                    24   :seg0=7'b0010010;
                    25   :seg0=7'b0010010;
                    26   :seg0=7'b0010010;
                    27   :seg0=7'b0010010;
                    28   :seg0=7'b0010010;
                    29   :seg0=7'b0010010;
                    //30-39
                    30   :seg0=7'b0000110;
                    31   :seg0=7'b0000110;
                    32   :seg0=7'b0000110;
                    33   :seg0=7'b0000110;
                    34   :seg0=7'b0000110;
                    35   :seg0=7'b0000110;
                    36   :seg0=7'b0000110;
                    37   :seg0=7'b0000110;
                    38   :seg0=7'b0000110;
                    39   :seg0=7'b0000110;
                    //40-49
                    40   :seg0=7'b1001100;
                    41   :seg0=7'b1001100;
                    42   :seg0=7'b1001100;
                    43   :seg0=7'b1001100;
                    44   :seg0=7'b1001100;
                    45   :seg0=7'b1001100;
                    46   :seg0=7'b1001100;
                    47   :seg0=7'b1001100;
                    48   :seg0=7'b1001100;
                    49   :seg0=7'b1001100;
                    //50-59
                    50   :seg0=7'b0100100;
                    51   :seg0=7'b0100100;
                    52   :seg0=7'b0100100;
                    53   :seg0=7'b0100100;
                    54   :seg0=7'b0100100;
                    55   :seg0=7'b0100100;
                    56   :seg0=7'b0100100;
                    57   :seg0=7'b0100100;
                    58   :seg0=7'b0100100;
                    59   :seg0=7'b0100100;
                    default: seg0=7'bx;
                endcase
            end
        end
*/
endmodule
