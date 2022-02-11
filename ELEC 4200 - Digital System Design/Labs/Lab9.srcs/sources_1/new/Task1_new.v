`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 03/24/2021 07:19:33 PM
// Design Name: 
// Module Name: Task1
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


module Task1_new (multiplicand, multiplier, clk, start, product, done);
input [2:0] multiplicand;
input [2:0] multiplier;
input clk, start;
output reg [5:0] product;
output reg done;
reg [6:0] acc;
//reg SI;
//wire SO;
//reg [6:0] tmp1;
//reg [2:0] tmp2;
integer n = 0;
reg [6:0] Q; 
reg [1:0] state, nextstate;
parameter [1:0] S0=0, S1=1, S2=2;
//reg parity;
//Main Code
////////////////////////////////////////////////////
always @ (posedge clk)
state <= nextstate;

//begin
always @(state or posedge start)
begin
    nextstate = 1'b0;
//    done = 0;
    case(state)
    //Start State
    S0: if (start)
            begin
            acc[6:3] = 4'b0000;
            acc[2:0] = multiplier;
            done = 0;
            n = 0;
            nextstate = S1;
            end
            //if start 0
            else
            nextstate = S0;  
    //accumulate state
    S1: if (acc[0] == 1 &  n <= 2)
            begin
            acc[6:3] = acc [6:3] + multiplicand;
            nextstate = S2;
            end
            else
            nextstate = S2;        
    //shift state   
    S2: if (n <= 2) 
            begin
            acc = {1'b0, acc[6:1]};
            product = acc[5:0];
            n = n + 1;
            nextstate = S1;
            end
            else
            begin
            done = 1;
            nextstate = S0;
            end
    endcase     
end
endmodule
