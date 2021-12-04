`timescale 1ns / 1ps
module branchMUX( 
input [15:0] PCadder,
input [15:0] signExtAdder,
input branchGate,
input jump,
input clk,
output reg [15:0] branchMUX_out
);

//assign PCadder = 0; //testing
//assign branchGate = 0; //testing
//assign jump = 0; //testing

always @(clk) //signExtAdder&PCadder&branchGate
begin
if (branchGate == 1 | jump == 1) begin
branchMUX_out = signExtAdder;
end
else begin
branchMUX_out = PCadder;
end
end

endmodule