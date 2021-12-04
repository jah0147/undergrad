module DataMemoryMUX(
input [15:0] dataMem,
input [15:0] ALU,
input MemToReg,
output reg [15:0] mux3out
);

always @(MemToReg | ALU) begin //change this to include dataMem
if (MemToReg == 1) begin
mux3out = dataMem;
end
else begin
mux3out = ALU;
end
end

endmodule