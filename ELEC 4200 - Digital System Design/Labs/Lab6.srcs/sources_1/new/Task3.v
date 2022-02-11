`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 02/23/2021 07:08:52 PM
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


module Task3(
input reset,
input En,
input clk_in, //100Mhz from board
output reg Q,
output lock_signal
);
wire clk_out1;


clk_wiz_0 clockingwizard (.clk_in1(clk_in), .clk_out1(clk_out1), .locked(lock_signal));

integer counter = 0;

always @(posedge clk_out1 or posedge reset)
 begin
if(reset)
Q <= 1'b0;
else
if(En) begin
if (counter == 2500000) begin
Q <= ~Q;
counter = 0;
end
else
counter = counter + 1;
end
end

endmodule
