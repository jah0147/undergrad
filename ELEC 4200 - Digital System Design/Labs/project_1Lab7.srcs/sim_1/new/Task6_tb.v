`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 03/03/2021 11:20:03 PM
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


module Task6_tb( );
reg t, Clk, clr, enable;
wire q;
integer k;

Task6 DUT (.t(t), .Clk(Clk), .clr(clr), 
    .q(q), .enable(enable));
  
        initial begin
        #400 $finish; //runs simulation 100 times
        end
        //clock
        initial begin
        for (k = 0; k <= 1000; k = k+1)
        begin
        Clk = 0;
        #5 Clk = 1;
        #5;
        Clk = 0;
        end
        end
        initial begin
        enable = 0;
        #20 enable = 1;
        #80 enable = 0;
        #40 enable = 1;
        end
        initial begin
        clr = 0;
        #60
        clr = 1;
        end
endmodule
