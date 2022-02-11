`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 03/11/2021 10:01:33 AM
// Design Name: 
// Module Name: Task3_R1_tb
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


module Task3_R1_tb();
reg in;
wire r1, r2, r3, r4, r5, r6, r7, r8, r9, r10;
wire out;
Task3_R1 DUT (.in(in), .out(out));
    
    assign r1 = DUT.r1;
    assign r2 = DUT.r2;
    assign r3 = DUT.r3;
    assign r4 = DUT.r4;
    assign r5 = DUT.r5;
    assign r6 = DUT.r6;
    assign r7 = DUT.r7;
    assign r8 = DUT.r8;
    assign r9 = DUT.r9;
    assign r10 = DUT.r10;
    
    initial begin
    #1550 $finish; //runs simulation 1550 times
    end
            
    initial begin
    in = 0;
    #150 in = 1;
            
      end
endmodule
