`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 02/03/2021 11:33:28 PM
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
    input [1:0] a,
    input [1:0] b,
    output [3:0] c
    );
    
    wire [3:0] ROM_addr;
    reg [3:0] ROM [15:0];
      
     assign ROM_addr = {a[1:0], b[1:0]};
     assign c = ROM[ROM_addr];
     
     begin
     initial $readmemb("Multiply.mem", ROM, 0, 15);
     end
endmodule
