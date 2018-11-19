//
//  IMUIFileMessageCell.swift
//  RCTAuroraIMUI
//
//  Created by Liuy on 2018/8/16.
//  Copyright © 2018年 HXHG. All rights reserved.
//

import Foundation
import UIKit

class IMUIFileMessageCell: IMUIBaseMessageCell {
    
    var backView = UIView()
    var fileIconImg = UIImageView(image:UIImage(named:"fileThumb"))
    var fileNameLable = UILabel()
    var lineView = UIView()
    var fileDescriptionLable = UILabel()
    let screenW = UIScreen.main.bounds.size.width
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        backView.backgroundColor = UIColor.white
        fileIconImg.contentMode = UIViewContentMode.scaleAspectFill
        fileNameLable.textColor = UIColor.black
        fileNameLable.font = UIFont.systemFont(ofSize: (screenW * 16 / 375))
        fileNameLable.numberOfLines = 2
        lineView.backgroundColor = UIColor.init(red: 230/255.0, green: 230/255.0, blue: 230/255.0, alpha: 1.0)
        fileDescriptionLable.textColor = UIColor.gray
        fileDescriptionLable.font = UIFont.systemFont(ofSize: (screenW * 11 / 375))
        
        bubbleView.addSubview(backView)
        backView.addSubview(fileIconImg)
        backView.addSubview(fileNameLable)
        backView.addSubview(lineView)
        backView.addSubview(fileDescriptionLable)
    }
    
    required init?(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    override func layoutSubviews() {
        super.layoutSubviews()
    }
    
    override func presentCell(with message: IMUIMessageModelProtocol, viewCache: IMUIReuseViewCache , delegate: IMUIMessageMessageCollectionViewDelegate?) {
        super.presentCell(with: message, viewCache: viewCache, delegate: delegate)
        let layout = message.layout
        
        self.backView.frame = CGRect(origin: CGPoint.zero, size: layout.bubbleFrame.size)
        let tmpDict = message.customDict
        let file_ext = tmpDict.object(forKey: "ext") as! String
        let file_size = tmpDict.object(forKey: "size") as! String
        let name = tmpDict.object(forKey: "name") as! String
        let fileDescription_str = "文件格式:\(file_ext) 文件大小:\(file_size)"
        fileDescriptionLable.text = fileDescription_str
        fileNameLable.text = name
        
        let lineY = layout.bubbleFrame.size.height * 0.78
        
        let contentX = layout.bubbleFrame.size.width * 0.04
        let contentWH = lineY - contentX * 2;
        fileIconImg.frame = CGRect(x:contentX,y:contentX,width:contentWH,height:contentWH)
        
        let fileNameX = contentX * 2 + contentWH
        let fileNameW =  layout.bubbleFrame.size.width - fileNameX - contentX
        fileNameLable.frame = CGRect(x:fileNameX,y:contentX,width:fileNameW,height:contentWH)
        
        lineView.frame = CGRect(x:0,y:lineY,width:layout.bubbleFrame.size.width,height:1)
        
        let fileDescriptionX = contentX
        let fileDescriptionH = layout.bubbleFrame.size.height - lineY
        fileDescriptionLable.frame = CGRect(x:fileDescriptionX,y:lineY,width:layout.bubbleFrame.size.width,height:fileDescriptionH)
        
    }
    
    func heightWithFont(font : UIFont, fixedWidth : CGFloat, text : String) -> CGSize {
        guard text.characters.count > 0 && fixedWidth > 0 else {
            return CGSize.zero
        }
        let size = CGSize(width:fixedWidth, height:CGFloat(MAXFLOAT))
        let rect = text.boundingRect(with: size, options:.usesLineFragmentOrigin, attributes: [NSFontAttributeName : font], context:nil)
        
        return rect.size
    }
    
}


