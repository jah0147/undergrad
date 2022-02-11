`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 03/03/2021 10:52:09 PM
// Design Name: 
// Module Name: Task5_tb
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


module Task5_tb();
reg Clk, ShiftIn, ShiftEn;
wire ShiftOut;
wire [3:0] ParallelOut;
integer k;
    
    Task5 DUT (.ShiftIn(ShiftIn), .ShiftEn(ShiftEn), 
    .Clk(Clk), .ShiftOut(ShiftOut), .ParallelOut(ParallelOut));
  
        initial begin
        #400 $finish; //runs simulation 100 times
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
        ShiftEn = 0;
        #40 ShiftEn = 1;
        #40 ShiftEn = 0;
        #40 ShiftEn = 1;
        #40 ShiftEn = 0;
        #80 ShiftEn = 1;
        #40 ShiftEn = 0;
        #40 ShiftEn = 1;
        #40 ShiftEn = 0;
        end
        initial begin
        ShiftIn = 1;
        #200 ShiftIn = 0;
        end
endmodule
