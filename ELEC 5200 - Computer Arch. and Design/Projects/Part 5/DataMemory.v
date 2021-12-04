`timescale 1ns / 1ps

module DataMemory(
input clk,   
input writeEn, //write enable
input  [15:0] ALU, //read/write address (ALU output)
input  [15:0] r2, //data input (R2 from regFile)
output [15:0] dataMemOut  //data output
);
reg    [15:0] ram [31:0]; 
     
      always @(posedge clk) begin   
        if (writeEn)   
          ram[ALU] = r2;   
      end   
      assign dataMemOut = ram[ALU];   
    endmodule
