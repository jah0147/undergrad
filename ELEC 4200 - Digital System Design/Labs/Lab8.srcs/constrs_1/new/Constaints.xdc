create_macro RO
update_macro [get_macros RO] -rlocs {w1_inferred_i_1 X0Y0 w2_inferred_i_1 X0Y0 w3_inferred_i_1 X0Y0 w4_inferred_i_1 X0Y1 w5_inferred_i_1 X1Y0}
set_property BEL D6LUT [get_cells w1_inferred_i_1]
set_property LOC SLICE_X0Y0 [get_cells w1_inferred_i_1]

create_macro R1
update_macro [get_macros R1] -rlocs {r1_inferred_i_1 X0Y0 r2_inferred_i_1 X0Y0 r3_inferred_i_1 X0Y0 r4_inferred_i_1 X0Y1 r5_inferred_i_1 X1Y0 r6_inferred_i_1 X1Y0 r7_inferred_i_1 X1Y0 r8_inferred_i_1 X1Y0 r9_inferred_i_1 X1Y0}
set_property BEL D6LUT [get_cells r1_inferred_i_1]
set_property LOC SLICE_X0Y0 [get_cells r1_inferred_i_1]
