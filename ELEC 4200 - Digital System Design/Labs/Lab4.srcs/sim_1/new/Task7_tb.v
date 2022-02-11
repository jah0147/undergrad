`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 02/10/2021 11:42:14 PM
// Design Name: 
// Module Name: Task7_tb
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


module Task7_tb();
reg D;
reg Clk;
reg ce;
reg reset;
wire Q;
integer k;

Task7 DUT (.Clk(Clk), .reset(reset), .D(D), .ce(ce), .Q(Q));
     initial begin
       #300 $finish; //runs simulation 300 times
       end
       
       initial begin
       D = 0;
       ce = 0;
       reset = 0;
       #20 //20
       D = 1;
       #40 //60
       ce = 1;
       #20 //80
       ce = 0;
       #20 //100
       D = 0;
       #20 //120
       reset = 1;
       #20 //140
       reset = 0;
       #40 //180
       ce = 1;
       #20 //200
       ce = 0;
       #20 //220
       D = 1;
       end
       
       //Clock
            initial begin
                for (k = 0; k <= 15; k = k+1)
                begin
                    Clk = 0;
                    #10 Clk = 1;
                    #10;
                    Clk = 0;
                    end
               end 
endmodule
