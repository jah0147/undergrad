`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 02/23/2021 06:10:07 PM
// Design Name: 
// Module Name: Task1_tb
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


module Task1_tb(
);
reg a0, a1, a2, a3, s1, s0;
wire z;

Task1 DUT (.a0(a0), .a1(a1), .a2(a2), .a3(a3), .s0(s0), .s1(s1), .z(z));

initial begin
    #100 $finish; //runs simulation 100 times
    end

initial begin
s0 = 0;
s1 = 0;
a0 = 1;
#10
s1 = 0;
s0 = 1;
a1 = 0;
#10
s1 = 1;
s0 = 0;
a2 = 1;
#10
s1 = 1;
s0 = 1;
a3 = 0;

end
endmodule
