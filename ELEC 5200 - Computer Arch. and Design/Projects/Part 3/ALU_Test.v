`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 10/27/2021 10:58:06 PM
// Design Name: 
// Module Name: ALU_Test
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


module ALU_Test();

//temp input/output of reg for testing
reg [1:0] r1;
reg [1:0] r2;
wire [3:0] rd;

reg regFile;
reg mux2; //mux for regFile/SignExtended
reg ALUControl;
wire data;
wire branch_gate; //compair output for branches

ALU DUT (.r1(r1), .r2(r2), .rd(rd), .regFile(regFile), 
.mux2(mux2), .ALUControl(ALUControl), .data(data), .branch_gate(branch_gate));

initial begin
#10
r1 = 1;
r2 =1;
ALUControl = 1;
#30 $finish;

end

endmodule
