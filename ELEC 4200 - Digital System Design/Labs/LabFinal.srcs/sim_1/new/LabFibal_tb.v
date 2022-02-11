`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 04/13/2021 09:51:09 PM
// Design Name: 
// Module Name: LabFinal_tb
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


module LabFinal_tb();
reg start;
reg reset;
reg clkIn; //clock input 1
reg clk;
reg pulse; //clock input 2
//output reg [11:0] timer, //full time value
wire [7:0] AN; //Output for 7-seg display constraints
wire [6:0] seg0; //7 segment display
//output reg [5:0] milliseconds,
wire [5:0] milliseconds, seconds;

integer k;

LabFinal_NoDisplay MUL (.start(start), .reset(reset), 
.clkIn(clkIn), .milliseconds(milliseconds), .seconds(seconds));

initial begin
#900000 $finish; //runs simulation 100 times
end
//clock
        initial begin
        for (k = 0; k <= 1000; k = k+1)
        begin
        clkIn = 0;
        #20 clkIn = 1;
        #20;
        clkIn = 0;
        end
        end
        
//start
        initial begin
        start = 0;
        #30 start = 1;
        /*
        #100 start = 0;
        #100 start = 1;
        #100 start = 0;
        #100 start = 1;
        */
   
        end   
        
//reset
/*
                initial begin
                reset = 0;
                #20 reset = 1;
                #100 reset = 0;
                
                end  
                */
endmodule
