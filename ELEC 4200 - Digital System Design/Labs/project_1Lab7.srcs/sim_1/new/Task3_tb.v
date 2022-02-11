`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 03/03/2021 09:40:34 PM
// Design Name: 
// Module Name: Task3_tb
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


module Task3_tb();

reg Clk, ShiftIn;
wire ShiftOut;
integer k;
    
    Task3 DUT (.ShiftIn(ShiftIn), .Clk(Clk), .ShiftOut(ShiftOut));
    
        initial begin
        #200 $finish; //runs simulation 100 times
        end
        //clock
        initial begin
        for (k = 0; k <= 1000; k = k+1)
        begin
        Clk = 0;
        #10 Clk = 1;
        #10;
        Clk = 0;
        end
        end
      initial begin
      ShiftIn = 0;
      #20 ShiftIn = 1;
      #40 ShiftIn = 0;
      #20 ShiftIn = 1;
      #40 ShiftIn = 0;
      end

endmodule
