`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date: 01/21/2021 09:14:52 AM
// Design Name: 
// Module Name: Mux31
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


module Mux31(
    input u,
    input v,
    input w,
    input s0,
    input s1,
    output m
    );
    and Int1 (Out1, s0, u, v); //getting First And Gate on First Mux
    and Int2 (m, Out1, w, s1); //Second and for Mux using first And Output. Makes 3-1 Mux
    
    
    
    
endmodule
