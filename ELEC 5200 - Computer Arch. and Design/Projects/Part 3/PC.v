module PC(
input clk, //the clock
input reset, //resets PC
input [9:0] MUX2, //the input from MUX2 will change the count on PC
output reg PC  //the output of pc will tell instuction memory where to point
);

begin
always @(clk | reset)

if (reset == 1) begin //if reset is active, reset pc to 0
PC = 0; //resets PC to 0
end

else begin  //if reset is not active, then PC will equal MUX2
PC = MUX2; //mux2 is the PC mux. It will either equad PC+1 or PC +branch/jump location
end
end
endmodule