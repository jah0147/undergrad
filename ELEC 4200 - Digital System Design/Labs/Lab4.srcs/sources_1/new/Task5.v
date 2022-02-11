`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 02/10/2021 10:52:21 PM
// Design Name: 
// Module Name: Task5
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


module Task5(
    input Clk,
    input D,
    output reg Qa,
    output reg Qb,
    output reg Qc
    );
    
    reg Qbar;
    
    always @ (D or Clk) 
    if(Clk)
    begin
    Qa <= D;
    Qbar <= ~D;
    end 
    
    always @ (posedge Clk)
        if(Clk) 
        begin
        Qb <= D;
        end
        
        always @ (negedge Clk)
            begin
            Qc <= D;
            end  
    
endmodule
