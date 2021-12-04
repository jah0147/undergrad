module SignExtPCAdder(
input [15:0] PC,
input [15:0] signExt,
output reg [15:0] SignExtPCAdderOut //sign extended immediates output. Max value should not be over 10-bits
);

always @(signExt)
begin
SignExtPCAdderOut = signExt + PC;
end

endmodule