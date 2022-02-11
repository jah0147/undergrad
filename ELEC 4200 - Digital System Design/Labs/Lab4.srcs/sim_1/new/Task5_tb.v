`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 02/10/2021 11:01:22 PM
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


module Task5_tb(
    );
    reg Clk;
    reg D;
    wire Qa;
    wire Qb;
    wire Qc;
    integer k;
    
    Task5 DUT (.D(D), .Clk(Clk), .Qa(Qa), .Qb(Qb), .Qc(Qc));
     initial begin
       #300 $finish; //runs simulation 300 times
       end
       
       initial begin
       D = 0;
       #50
       D = 1;
       #20 //70
       D = 0;
       #10 //80
       D = 1;
       #20 //100
       D = 0;
       #30 //130
       D = 1;
       #20 //150
       D = 0;
       #10 //160
       D = 1;
       #10 //170
       D = 0;
       #20 //190
       D = 1;
       #10 //200
       D = 0;
       #10 //210
       D = 1;
       #40 //250
       D = 0;
       end
 
      initial begin
      for (k = 0; k <= 6; k = k+1)
      begin
          Clk = 0;
          #60 Clk = 1;
          #60;
          Clk = 0;
          end
      end
endmodule
