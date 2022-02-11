`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 03/03/2021 11:18:27 PM
// Design Name: 
// Module Name: Task6
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


module Task6(input t);
wire t1, t2, t3, t4, t5, t6, t7, t8;
reg enable, Clk, clr;
wire q, q1, q2, q3, q4, q5, q6, q7, q8;

TFlipFlop U1 (.t(t), .enable(enable), .Clk(Clk), .clr(clr), .q(q1));
and (t2, t1, q1);
TFlipFlop U2 (.t(t2), .enable(enable), .Clk(Clk), .clr(clr), .q(q1));
and (t3, t2, q2);
TFlipFlop U3 (.t(t3), .enable(enable), .Clk(Clk), .clr(clr), .q(q3));
and (t4, t3, q3);
TFlipFlop U4 (.t(t2), .enable(enable), .Clk(Clk), .clr(clr), .q(q1));


endmodule
