`timescale 1ns / 1ps
module PCAdder(
input [15:0] PC_in,
output reg [15:0] PCAdderOut //sign extended immediates output. Max value should not be over 10-bits
);

always @(PC_in)
begin
PCAdderOut = 1 + PC_in;
end

endmodule