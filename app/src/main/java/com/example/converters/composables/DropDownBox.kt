package com.example.converters.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DropDownBox(
    dropDownList: List<String>,//list of values
    textValue: String,//text inside box
    labelText: String,//name of drop down box
    scrollState: ScrollState,//allows to scroll vertical or horizontal
    isExpanded: Boolean,//scroll list open or not
    expandStatus: (Boolean) -> Unit= {},//will check whether dropdown is open or not and work a/c
    valueChange: (String) -> Unit = {},//
){
    Column {
        Box(
            modifier = Modifier
                .border(
                    width = 1.dp, color = MaterialTheme.colors.primary,
                    shape = RoundedCornerShape(10)
                )
                .padding(vertical = 5.dp, horizontal = 10.dp)
                .clickable { expandStatus(!isExpanded) }
        ){
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if(textValue.isBlank()) {//when empty name of dropdown menu will be the value
                    Text(
                        text = labelText,
                        color = Color.Gray
                    )
                }
                Text(text = textValue)//text to be shown
                IconButton(onClick = {
                    expandStatus(!isExpanded)
                }) {
                    Icon(imageVector = Icons.Default.ArrowDropDown,//down arrow
                        contentDescription = "Arrow Dropdown",
                        tint = Color.Black
                    )
                }
            }
        }
        AnimatedVisibility(visible = isExpanded) { //animates the appearance and disappearance of objects
            Card(modifier = Modifier.padding(top = 1.dp)//the background of list or sequence that will appear
                , elevation = 6.dp,
                shape = RoundedCornerShape(20),
                backgroundColor = if(!isSystemInDarkTheme()) MaterialTheme.colors.primary else MaterialTheme.colors.surface
            ) {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .requiredHeightIn(max = 250.dp)//limits the height
                    .clip(RoundedCornerShape(10.dp))//makes column of this shape
                    .verticalScroll(scrollState)//the column is now vertically scrollable
                ) {
                    dropDownList.forEach {label ->//label of every list item is DropDownMenuItem
                        DropdownMenuItem(onClick = {
                            valueChange(label) //value will be replaced by one clicked on 'labelName'
                            expandStatus(false)//dropdown closes
                        }) {
                            Text(text = label, style = MaterialTheme.typography.h2
                            )
                        }
                    }
                }
            }
        }
    }

}
