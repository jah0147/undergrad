`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 03/03/2021 09:38:31 PM
// Design Name: 
// Module Name: Task3
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


module Task3(input Clk, input ShiftIn, output ShiftOut);
reg [2:0] shift_reg;
always @(posedge Clk)
shift_reg <= {shift_reg[1:0], ShiftIn};
assign ShiftOut = shift_reg[2];
endmodule
