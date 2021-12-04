module BranchGate(
input ALU,
input branch,
output reg BranchGateOut //sign extended immediates output. Max value should not be over 10-bits
);
//assign branch = 0; //testing

always @ (ALU)
begin
BranchGateOut = ALU & branch;
end

endmodule
