`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 01/14/2021 09:30:16 AM
// Design Name: 
// Module Name: Mux21
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


module Mux21(
    input Din0,
    input Din1,
    input Sel,
    output Dout1,
    output Dout2
    );
    
    assign Dout1 = (Din0 & ~Sel) | (Din1 & Sel);
    
    reg Dout2;
    always @ (Din0 or Din1 or Sel)
    begin
        if (Sel==1)
            Dout2 = Din1;
        else
            Dout2 = Din0;
    end 
endmodule
