`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 03/03/2021 09:50:52 PM
// Design Name: 
// Module Name: Task4_tb
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


module Task4_tb();
reg Clk, ShiftIn, load, ShiftEn;
reg [3:0] ParallelIn;
wire ShiftOut;
wire [3:0] RegContent;
integer k;
    
    Task4 DUT (.ShiftIn(ShiftIn), .load(load), .ShiftEn(ShiftEn), .Clk(Clk),
   .ParallelIn(ParallelIn), .ShiftOut(ShiftOut), .RegContent(RegContent));
    
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
        //load
      initial begin
      load = 0;
      #60 load = 1;
      #20 load = 0;
      #120 load = 1;
      #20 load = 0;
      #55 load = 1;
      #20 load = 0;
      #55 load = 1;
      #20 load = 0;
      end
      //ShiftEn and SHiftIn
      initial begin
      ShiftIn = 1;
      ShiftEn = 0;
      #100 ShiftEn = 1;
      #220 ShiftEn = 0;
      end
      //ParallelIn
      initial begin
      ParallelIn = 0;
      #20 ParallelIn = 4'b0101;
      #160 ParallelIn = 4'b1001;
      end
endmodule
