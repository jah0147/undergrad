`timescale 1ns / 1ps
module RegisterFile(
input clk,
input reset,
input [15:0] Instruction,
input [15:0] mux3out, //set to ouput of mux 3
input RegWrite,//registerWrite enables if 1
output  [15:0] r1,
output  [15:0] r2
);
//wire [15:0] Instruction;
reg [15:0] REG_FILE [0:7];
wire [2:0] r1Parse;
wire [2:0] r2Parse;
wire [2:0] rdParse;

//assign RegWrite = 0; //testing

//assign Instruction = 16'b0001001000001000; //add x1 and x1

//setting r1,r2, and rd inputs from instrucMem
assign r1Parse = Instruction[11:9];
assign r2Parse = Instruction[14:12];
assign rdParse = Instruction[5:3]; //reg 2

assign r1 = REG_FILE[r1Parse];
assign r2 = REG_FILE[r2Parse];

initial begin


    REG_FILE[0] = 0;
    REG_FILE[1] = 0; //testing
    REG_FILE[2] = 0;
    REG_FILE[3] = 0;
    REG_FILE[4] = 0;
    REG_FILE[5] = 0;
    REG_FILE[6] = 0;
    REG_FILE[7] = 0;
    
end
    
    always @ (posedge clk | reset) begin
        if (reset) begin
        
        REG_FILE[0] = 0;
        REG_FILE[1] = 0;
        REG_FILE[2] = 0;
        REG_FILE[3] = 0;
        REG_FILE[4] = 0;
        REG_FILE[5] = 0;
        REG_FILE[6] = 0;
        REG_FILE[7] = 0;
        
        end
        if (RegWrite) //if RegWrite is enabled
            REG_FILE[rdParse] = mux3out;
           REG_FILE[0] = 0;
    end

endmodule