`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 02/10/2021 11:28:34 PM
// Design Name: 
// Module Name: Task6_tb
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


module Task6_tb();

reg D;
reg Clk;
reg reset;
wire Q;
integer k;

Task7 DUT (.Clk(Clk), .reset(reset), .D(D), .Q(Q));
     initial begin
       #100 $finish; //runs simulation 100 times
       end
       
       initial begin
       D = 0;
       reset = 0;
       #20 //20
       D = 1;
       #35 //55
       reset = 1;
       #5 //40
       reset = 0;
       #5 //45
       reset = 1;
       #10 //55
       reset = 0;
       end
    
    //Clock
     initial begin
         for (k = 0; k <= 5; k = k+1)
         begin
             Clk = 0;
             #10 Clk = 1;
             #10;
             Clk = 0;
             end
        end     
endmodule
